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
		LOG.info("Creating custom Internet Explorer driver");
		WebDriver driver = null;
		try {
			System.setProperty("webdriver.ie.driver",
					new File(PropertiesSerenityUtil.getProperty("webdriver.ie.driver"))
							.getAbsolutePath());
		} catch (PropertyException e) {
			throw new RuntimeException(
					"Problem in getting the key 'webdriver.ie.driver' from the file 'thucydides.properties'",
					e);
		}
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		driver = new InternetExplorerDriver(capabilities);
		return driver;
	}

	@Override
	public boolean takesScreenshots() {
		return true;
	}
}
