package io.openbdt.driver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.annotation.PostConstruct;
import javax.xml.bind.PropertyException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.stereotype.Component;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.openbdt.properties.PropertiesSerenityUtil;
import net.thucydides.core.webdriver.DriverSource;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import net.thucydides.core.webdriver.WebDriverFacade;

@Component
public class MobileCustomDriver implements DriverSource {

	private DesiredCapabilities capabilities;

	@PostConstruct
	private void init() throws PropertyException {
		capabilities = new DesiredCapabilities();
		String platformName = PropertiesSerenityUtil
				.getProperty("webdriver.provided.io.openbdt.driver.MobileCustomDriver.platformName");

		File app = new File(
				PropertiesSerenityUtil.getProperty("webdriver.provided.io.openbdt.driver.MobileCustomDriver.app"));
		if (!app.exists())
			throw new RuntimeException(String.format("%s doesn't exist",
					PropertiesSerenityUtil.getProperty("webdriver.provided.io.openbdt.driver.MobileCustomDriver.app")));
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("noReset", Boolean.parseBoolean(
				PropertiesSerenityUtil.getProperty("webdriver.provided.io.openbdt.driver.MobileCustomDriver.noReset")));
		capabilities.setCapability("udid",
				PropertiesSerenityUtil.getProperty("webdriver.provided.io.openbdt.driver.MobileCustomDriver.udid"));
		capabilities.setCapability("platformVersion", PropertiesSerenityUtil
				.getProperty("webdriver.provided.io.openbdt.driver.MobileCustomDriver.platformVersion"));
		capabilities.setCapability("deviceName", PropertiesSerenityUtil
				.getProperty("webdriver.provided.io.openbdt.driver.MobileCustomDriver.deviceName"));
		String host = PropertiesSerenityUtil
				.getProperty("webdriver.provided.io.openbdt.driver.MobileCustomDriver.host");
		if (platformName.equalsIgnoreCase("android")) {
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("appActivity", PropertiesSerenityUtil
					.getProperty("webdriver.provided.io.openbdt.driver.MobileCustomDriver.appActivity"));
			capabilities.setCapability("appWaitActivity", PropertiesSerenityUtil
					.getProperty("webdriver.provided.io.openbdt.driver.MobileCustomDriver.appWaitActivity"));
			capabilities.setCapability("appPackage", PropertiesSerenityUtil
					.getProperty("webdriver.provided.io.openbdt.driver.MobileCustomDriver.appPackage"));
		} else if (platformName.equalsIgnoreCase("ios")) {
			capabilities.setCapability("platformName", "iOS");
			capabilities.setCapability("bundleId", PropertiesSerenityUtil
					.getProperty("webdriver.provided.io.openbdt.driver.MobileCustomDriver.bundleId"));
			capabilities.setCapability("xcodeConfigFile", new File(PropertiesSerenityUtil
					.getProperty("webdriver.provided.io.openbdt.driver.MobileCustomDriver.xcodeConfigFile")).getAbsolutePath());
		}
	}

	@Override
	public WebDriver newDriver() {
		try {
			init();
		} catch (PropertyException e) {
			e.printStackTrace();
		}
		String platformName = capabilities.getCapability("platformName").toString();
		try {
			AppiumDriver<MobileElement> appiumDriver;
			if (platformName.equalsIgnoreCase("android")) {
				AndroidDriver<AndroidElement> androidDriver = new AndroidDriver<AndroidElement>(new URL(PropertiesSerenityUtil
						.getProperty("webdriver.provided.io.openbdt.driver.MobileCustomDriver.host")),
						capabilities);
				appiumDriver = (AppiumDriver) androidDriver;
				return androidDriver;
			} else if (platformName.equalsIgnoreCase("ios")) {
				IOSDriver<IOSElement> iosDriver = new IOSDriver<IOSElement>(new URL(PropertiesSerenityUtil
						.getProperty("webdriver.provided.io.openbdt.driver.MobileCustomDriver.host")), capabilities);
				appiumDriver = (AppiumDriver) iosDriver;
				return iosDriver;
			}
		} catch (PropertyException e1) {
			e1.printStackTrace();
			throw new RuntimeException("Some required properties were not found", e1);
		} catch (MalformedURLException e2) {
			e2.printStackTrace();
			throw new RuntimeException("URL exception", e2);
		}
		throw new RuntimeException("Unable to instantiate the driver");
	}

	@Override
	public boolean takesScreenshots() {
		return true;
	}

	@Override
	public Class<? extends WebDriver> driverType() {
		return AppiumDriver.class;
	}

	public AppiumDriver<MobileElement> getAppiumDriver() {
		return ((AppiumDriver<MobileElement>)((WebDriverFacade)ThucydidesWebDriverSupport.getDriver()).getProxiedDriver());
	}

	public String getUdid() {
		return this.capabilities.getCapability("udid").toString();
	}

	public String getPlatformVersion() {
		return this.capabilities.getCapability("platformVersion").toString();
	}

	public String getPlatformName() {
		return this.capabilities.getCapability("platformName").toString();
	}
}
