package io.openbdt.types;

/**
 * 
 * @author splait
 *
 */
public enum MobileDriverType {
	ANDROID_DRIVER("io.appium.java_client.android.AndroidDriver"),
	
	IOS_DRIVER("io.appium.java_client.ios.IOSDriver");
	
	/**
	 * 
	 */
	private String fullQualifyNameDriver;
	
	/**
	 * 
	 * @param fullQualifyNameDriver
	 */
	private MobileDriverType(final String fullQualifyNameDriver) {
		this.fullQualifyNameDriver = fullQualifyNameDriver;
	}
	
	/**
	 * @return the fullQualifyNameDriver
	 */
	public String getFullQualifyNameDriver() {
		return fullQualifyNameDriver;
	}
}
