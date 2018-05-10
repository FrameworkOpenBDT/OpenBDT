package io.openbdt.driver;

import java.io.File;

import javax.xml.bind.PropertyException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.openqa.selenium.winium.WiniumDriverService;
import org.springframework.stereotype.Component;

import io.openbdt.properties.PropertiesSerenityUtil;
import net.thucydides.core.webdriver.DriverSource;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import net.thucydides.core.webdriver.WebDriverFacade;

@Component
public class DesktopDriver implements DriverSource {

	private Logger LOG = Logger.getLogger(DesktopDriver.class);

	private WiniumDriverService service;
	
	private DesktopOptions options;
	
	public void init() throws PropertyException {
		this.service = new WiniumDriverService.Builder().usingDriverExecutable(
				new File(PropertiesSerenityUtil.getProperty("webdriver.provided.io.openbdt.driver.DesktopDriver.path"))
						.getAbsoluteFile())
				.usingPort(Integer.parseInt(
						PropertiesSerenityUtil.getProperty("webdriver.provided.io.openbdt.driver.DesktopDriver.port")))
				.withVerbose(Boolean.parseBoolean(PropertiesSerenityUtil.getProperty("driver.log.verbose")))
				.withSilent(Boolean.parseBoolean(PropertiesSerenityUtil.getProperty("driver.log.silent")))
				.buildDesktopService();

		this.options = new DesktopOptions();
		options.setApplicationPath(PropertiesSerenityUtil.getProperty("application.path"));
		LOG.debug("driver requirements created");
	}

	public WiniumDriver getDriver() {
		return ((WiniumDriver)((WebDriverFacade)ThucydidesWebDriverSupport.getDriver()).getProxiedDriver());
	}
	
	@Override
	public WebDriver newDriver() {
		try {
			init();
			LOG.debug(String.format("driver requirements:\\nservice: %s\\noptions: %s", service, options));
		} catch (PropertyException e) {
			e.printStackTrace();
		}
		return new WiniumDriver(service, options);
	}
	
	@Override
	public Class<? extends WebDriver> driverType() {
		return WiniumDriver.class;
	}

	@Override
	public boolean takesScreenshots() {
		return true;
	}
}