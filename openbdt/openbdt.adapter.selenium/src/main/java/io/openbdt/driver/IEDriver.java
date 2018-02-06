package io.openbdt.driver;

import java.io.File;

import javax.xml.bind.PropertyException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.openbdt.properties.PropertiesSerenityUtil;
import net.thucydides.core.webdriver.DriverSource;

public class IEDriver implements DriverSource {

	private Logger LOG = Logger.getLogger(IEDriver.class);

	@Override
	public WebDriver newDriver() {
		LOG.info("############################");
		LOG.info("Creating driver");
		LOG.info("############################");
		try {
			System.setProperty("webdriver.ie.driver", new File(PropertiesSerenityUtil.getProperty("webdriver.provided.io.openbdt.driver.IEDriver.path")).getAbsolutePath());
		} catch (PropertyException e) {
			throw new RuntimeException("Key not found in thucydides.properties: 'webdriver.provided.io.openbdt.driver.IEDriver.path'");
		}
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		return new InternetExplorerDriver(capabilities);
	}

	@Override
	public boolean takesScreenshots() {
		return true;
	}

}
