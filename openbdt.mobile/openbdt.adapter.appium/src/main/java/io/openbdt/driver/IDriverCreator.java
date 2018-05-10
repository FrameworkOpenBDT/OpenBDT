package io.openbdt.driver;

import java.net.MalformedURLException;
import java.util.Map;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.openbdt.exception.ParameterNotFoundException;
import io.openbdt.types.MobileCapabilities;

/**
 * 
 * @author splait
 *
 * @param <Driver> The <b>driver class</b> to be instantiated<br>
 */
public interface IDriverCreator<Driver extends AppiumDriver<? extends MobileElement>>{

	/**
	 * Creates a driver with the specified properties as capabilities
	 * @param properties Driver capabilities
	 * @return
	 */
	Driver createDriver(Map<String, String> properties) throws MalformedURLException;
	
	/**
	 * Creates the capabilities to be used to create the driver
	 * @param properties Driver capabilities
	 * @throws ParameterNotFoundException
	 */
	DesiredCapabilities createCapabilities(Map<String, String> properties, MobileCapabilities capabilities) throws ParameterNotFoundException;
}
