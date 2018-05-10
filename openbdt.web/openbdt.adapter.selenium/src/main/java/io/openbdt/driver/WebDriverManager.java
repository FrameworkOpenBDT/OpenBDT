package io.openbdt.driver;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import io.openbdt.element.WebBrowserScreenElement;
import io.openbdt.exception.InstantiateDriverException;
import io.openbdt.types.SeleniumDriverType;

/**
 * Driver manager selenium
 * 
 */
@Component
public class WebDriverManager implements WebDriverContract<SeleniumDriverType, WebBrowserScreenElement> {

	/**
	 * LOG
	 */
	private Logger LOG = Logger.getLogger(WebDriverManager.class.getName());
	
	
	/**
	 * Get instance of driver manager selenium.
	 * 
	 * @param driverType 	- Driver<SeleniumDriverType>
	 * 
	 * @param properties	- Map<SeleniumCapabilities, String>
	 * 
	 * @throws InstantiateDriverException
	 * 
	 */
	@Override
	public WebBrowserScreenElement open(final SeleniumDriverType driverType, final Map<String, String> properties) throws InstantiateDriverException {
		try {
			LOG.info("loading driver: " + driverType.getFullQualifyNameDriver());
			
			return new WebBrowserScreenElement();
		
		} catch (Exception e) {
			LOG.fatal(e.getMessage(), e);
			throw new InstantiateDriverException(e);
		}
	}

	/**
	 * get reference to the WebBrowserScreenElement<br>
	 * 
	 * @see WebBrowserScreenElement
	 * 
	 * @param driver - WebDriver
	 * 
	 * @return WebBrowserScreenElement
	 */
	@Override
	public WebBrowserScreenElement getViewElement() {
		return new WebBrowserScreenElement();
	}
}