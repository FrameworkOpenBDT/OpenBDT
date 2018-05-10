package io.openbdt.types;

/**
 * Selenium driver type 
 * 
 */
public enum SeleniumDriverType {
	
	FIREFOX_DRIVER("org.openqa.selenium.firefox.FirefoxDriver"),
	
	CHROME_DRIVER("org.openqa.selenium.chrome.ChromeDriver"),
	
	INTERNET_EXPLORER_DRIVER("org.openqa.selenium.ie.InternetExplorerDriver"),
	
	HTML_UNIT_DRIVER("org.openqa.selenium.htmlunit.HtmlUnitDriver"),
	
	EDGE_DRIVER("org.openqa.selenium.edge.EdgeDriver"),
	
	SAFARI_DRIVER("org.openqa.selenium.safari.SafariDriver"),
	
	PHANTOM_JS_DRIVER("org.openqa.selenium.phantomjs.PhantomJSDriver");
	
	/**
	 * 
	 */
	private String fullQualifyNameDriver;
	
	/**
	 * 
	 * @param fullQualifyNameDriver
	 */
	private SeleniumDriverType(final String fullQualifyNameDriver) {
		this.fullQualifyNameDriver = fullQualifyNameDriver;
	}
	
	/**
	 * @return the fullQualifyNameDriver
	 */
	public String getFullQualifyNameDriver() {
		return fullQualifyNameDriver;
	}
}
