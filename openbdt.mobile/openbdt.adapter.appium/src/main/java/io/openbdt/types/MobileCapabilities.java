package io.openbdt.types;

import java.util.ArrayList;
import java.util.List;

/**
 * Mobile Capabilities (Android and iOS)
 * 
 * @author splait
 *
 */
public enum MobileCapabilities {

	ANDROID_APPIUM_CAPABILITIES("platformVersion", "app", "appPackage", "appWaitActivity", "platformName", "udid", "deviceName", "noReset"), 
	IOS_APPIUM_CAPABILITIES("platformVersion", "app", "platformName", "udid", "automationName", "deviceName", "xcodeConfigFile", "bundleId", "showXcodeLog", "noReset"),
	SELENIUM_GRID_ANDROID_CAPABILITIES("applicationName", "platformVersion", "app", "appPackage", "appWaitActivity", "platformName", "udid", "deviceName", "noReset"),
	SELENIUM_GRID_IOS_CAPABILITIES("applicationName", "platformVersion", "app", "platformName", "udid", "automationName", "deviceName", "xcodeConfigFile", "bundleId", "showXcodeLog", "noReset");
	
	private List<String> capabilites;
	
	
	private MobileCapabilities(String... capabilities){
		this.capabilites = new ArrayList<>();
		for(String capability: capabilities){
			this.capabilites.add(capability);
		}
	}
	
	/**
	 * 
	 * @return List containing capabilities
	 */
	public List<String> getCapabilities(){
		return this.capabilites;
	}
}
