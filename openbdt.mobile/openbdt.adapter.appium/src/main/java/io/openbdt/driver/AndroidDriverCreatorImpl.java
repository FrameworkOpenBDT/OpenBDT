package io.openbdt.driver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.openbdt.exception.ParameterNotFoundException;
import io.openbdt.types.MobileCapabilities;

public class AndroidDriverCreatorImpl implements IDriverCreator<AndroidDriver<AndroidElement>> {

	private static final Logger LOG = Logger.getLogger(AndroidDriverCreatorImpl.class);

	@Override
	public AndroidDriver<AndroidElement> createDriver(Map<String, String> properties)
			throws MalformedURLException, ParameterNotFoundException {
		AndroidDriver<AndroidElement> driver = null;
		boolean usingSeleniumGrid = properties.get("usingSeleniumGrid") != null
				&& properties.get("usingSeleniumGrid").equalsIgnoreCase("true");
		LOG.info(String.format("using selenium grid: %s", usingSeleniumGrid));
		DesiredCapabilities desiredCapabilities = null;
		if (usingSeleniumGrid) {
			desiredCapabilities = (DesiredCapabilities) createCapabilities(properties,
					MobileCapabilities.SELENIUM_GRID_ANDROID_CAPABILITIES);
		} else {
			desiredCapabilities = (DesiredCapabilities) createCapabilities(properties,
					MobileCapabilities.ANDROID_APPIUM_CAPABILITIES);
		}
		LOG.info(String.format("\nConnection configuration parameters\n"
				+ "\tServer address: %s\n"
				+ "\tServer port: %s\n"
				+ "\turl: %s\n", properties.get("serverAddress"), properties.get("serverPort"), String.format("http://%s:%s/wd/hub", properties.get("serverAddress"), properties.get("serverPort")) ));
		driver = new AndroidDriver<AndroidElement>(
				new URL("http://" + properties.get("serverAddress") + ":"
						+ properties.get("serverPort") + "/wd/hub"),
				desiredCapabilities);
		LOG.info(String.format("%s Driver successfully created", properties.get("udid")));
		return driver;
	}

	@Override
	public DesiredCapabilities createCapabilities(Map<String, String> properties, MobileCapabilities androidCapabilities)
			throws ParameterNotFoundException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		for (String capability : androidCapabilities.getCapabilities()) {
			if (properties.containsKey(capability)) {
				capabilities.setCapability(capability, properties.get(capability));
			} else {
				throw new ParameterNotFoundException("'" + capability + "' not found");
			}
		}
		return capabilities;
	}
}
