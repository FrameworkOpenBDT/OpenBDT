package io.openbdt.driver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.openbdt.exception.ParameterNotFoundException;
import io.openbdt.types.MobileCapabilities;

public class IOSDriverCreatorImpl implements IDriverCreator<IOSDriver<IOSElement>> {

	private static final Logger LOG = Logger.getLogger(IOSDriverCreatorImpl.class);
	
	@Override
	public IOSDriver<IOSElement> createDriver(Map<String, String> properties) throws MalformedURLException {
		IOSDriver<IOSElement> driver = null;
		boolean usingSeleniumGrid = properties.get("usingSeleniumGrid") != null
				&& properties.get("usingSeleniumGrid").equalsIgnoreCase("true");
		DesiredCapabilities desiredCapabilities = null;
		if(usingSeleniumGrid){
			desiredCapabilities = (DesiredCapabilities) createCapabilities(properties, MobileCapabilities.SELENIUM_GRID_IOS_CAPABILITIES); 
		}else{
			desiredCapabilities = (DesiredCapabilities) createCapabilities(properties, MobileCapabilities.IOS_APPIUM_CAPABILITIES);
		}
		LOG.info(String.format("\nConnection configuration parameters\n"
				+ "\tServer address: %s\n"
				+ "\tServer port: %s\n"
				+ "\turl: %s\n", properties.get("serverAddress"), properties.get("serverPort"), String.format("http://%s:%s/wd/hub", properties.get("serverAddress"), properties.get("serverPort")) ));
		 
		driver = new IOSDriver<IOSElement>(new URL("http://" + properties.get("serverAddress") + ":"  + properties.get("serverPort") + "/wd/hub"), desiredCapabilities);
		return driver;
	}

	@Override
	public DesiredCapabilities createCapabilities(Map<String, String> properties, MobileCapabilities ioscapabilities) throws ParameterNotFoundException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		for(String capability: ioscapabilities.getCapabilities()){
			if(properties.containsKey(capability)){
				capabilities.setCapability(capability, properties.get(capability));
			}else{
				throw new ParameterNotFoundException("'" + capability + "' not found");
			}
		}
		return capabilities;
	}

}
