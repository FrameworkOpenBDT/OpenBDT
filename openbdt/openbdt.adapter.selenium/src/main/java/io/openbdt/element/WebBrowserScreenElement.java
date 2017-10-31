package io.openbdt.element;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.springframework.stereotype.Component;

import com.google.common.base.Function;

import io.openbdt.api.BrowserElement;
import io.openbdt.exception.ElementNotFoundException;
import io.openbdt.exception.WebElementException;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;

/**
 * functions to interact with the web browser screen 
 * 
 */
@Component
public class WebBrowserScreenElement implements BrowserElement<WebElement, By> {
	
	/**
	 * LOG
	 */
	private Logger LOG = Logger.getLogger(WebBrowserScreenElement.class.getName());
	
	/**
	 * Timeout default
	 */
	public static final long DEFAULT_SECONDS_TIMEOUT_FIND_ELEMENT = 30;
	
	/**
	 * frequency find element during timeout
	 */
	public static final long DEFAULT_SECONDS_FREQUENCY_FIND_ELEMENT = 5;
	
	/**
	 * Referencia ao remoteWebElement
	 */
	private RemoteWebElement remoteWebElement;
	
	/**
	 * Construtor padrao
	 * 
	 */
	public WebBrowserScreenElement() {
		this.remoteWebElement = new RemoteWebElement();
	}
	
	
	/**
	 * Construtor utilizado web driver
	 * 
	 * @param remoteWebElement 	- RemoteWebElement
	 */
	public WebBrowserScreenElement(final RemoteWebElement remoteWebElement) {
		this.remoteWebElement = remoteWebElement;
	}
	

	/**
	 * Get the current driver
	 * 
	 * @return WebDriver
	 */
	public WebDriver getDriver() {
		return ThucydidesWebDriverSupport.getDriver();
	}

	
	/**
	 * Close the current connection 
	 * 
	 * @throws Exception
	 */
	@Override
	public void close() throws Exception {
		LOG.info("closing current driver");
		this.getDriver().quit();
	}

	
	/**
	 * Click in the specified web element
	 * 
	 * @param element - WebElement
	 * 
	 */
	@Override
	public void click(final WebElement element) {
		LOG.info("click: " + element);
		
		try {
			element.click();
			
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "", e);
			throw new WebElementException("Error on click element: " + element, e);
		}
	}
	
	/**
	 * Click the in the specified elements
	 * 
	 * @param WebElement[]
	 * 
	 */
	@Override
	public void click(final WebElement... elements) {
		LOG.info("click list elements");
		
		try {
			if (elements != null) {
				for (final WebElement element : elements) {
					this.click(element);
				}
			}
		} catch (WebElementException e) {
			throw e;
		}
	}
	
	
	/**
	 * Click the element and wait specified time if element is not visible
	 * 
	 * @param element - Element
	 * 
	 * @param timeoutSeconds - int
	 * 
	 */
	@Override
	public void clickAndWait(final WebElement element, final int timeoutSeconds) {
		LOG.info(new StringBuilder("Click element: ").append(element).append(" and wait for: ").append(timeoutSeconds).append(" seconds").toString());
		
		try {
			final FluentWait<WebDriver> fluent = this.createInstanceFluentWait(this.getDriver(), timeoutSeconds);

			final WebElement elementWaiting = fluent.until(ExpectedConditions.visibilityOf(element));
			
			elementWaiting.click();
			
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "", e);
			throw new WebElementException("Error on click element: " + element, e);
		}
	}
	
	/**
	 * Click the elements and wait specified time if element is not visible
	 * 
	 * @param timeoutSeconds - int
	 * 
	 * @param elements - Element[]
	 * 
	 */
	public void clickAndWait(final int timeoutSeconds, final WebElement... elements) {
		LOG.info("click list elements");
		
		try {
			if (elements != null) {
				for (final WebElement element : elements) {
					this.clickAndWait(element, timeoutSeconds);
				}
			}
		} catch (WebElementException e) {
			throw e;
		}
	}

	
	/**
	 * send submit action
	 * 
	 * @param element - WebElement
	 * 
	 */
	@Override
	public void submit(final WebElement element) {
		LOG.info("submit: " + element);
		
		try {
			final FluentWait<WebDriver> fluent = this.createInstanceFluentWait(this.getDriver());
			
			final WebElement btnSubmit = fluent.until(ExpectedConditions.visibilityOf(element));
			
			btnSubmit.submit();
			
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "", e);
			throw new WebElementException("Error on event submit: " + element, e);
		}
	}

	
	/**
	 * send text to the specified element
	 * 
	 * @param element 		- WebElement
	 * @param textToSend 	- String
	 * 
	 */
	@Override
	public void sendText(final WebElement element, final String textToSend) {
		LOG.info("sendText: " + element + " text: " + textToSend);
		
		try {
			element.sendKeys(textToSend);
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "", e);
			throw new WebElementException("Error on event sendkeys: " + element, e);
		}
	}

	
	/**
	 * clear the specified element
	 * 
	 * @param element - WebElement
	 * 
	 */
	@Override
	public void clear(final WebElement element) {
		LOG.info("clear element: " + element);
		
		try {
			element.clear();
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "", e);
			throw new WebElementException("Error on event clear: " + element, e);
		}
	}

	
	/**
	 * verify if specified element is selected
	 * 
	 * @param element - WebElement
	 * 
	 */
	@Override
	public boolean isSelected(final WebElement element) {
		LOG.info("is Selected: " + element);
		
		try {
			return element.isSelected();
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "", e);
			throw new WebElementException("Error verifying is selected: " + element, e);
		}
	}

	
	/**
	 * verify if specified element is enable
	 * 
	 * @param element - WebElement
	 * 
	 */
	@Override
	public boolean isEnabled(final WebElement element) {
		LOG.info("isEnable: " + element);
		
		try {
			return element.isEnabled();
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "", e);
			throw new WebElementException("Error verifying is enable: " + element, e);
		}
	}

	
	/**
	 * get text in the specified element 
	 * 
	 * @param element - WebElement
	 * 
	 */
	@Override
	public String getText(final WebElement element) {
		LOG.info("getText: " + element);
		
		try {
			return element.getText();
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "", e);
			throw new WebElementException("Error get text: " + element, e);
		}
	}

	
	/**
	 * Find elements by criteria 
	 * 
	 * @param criteria - By
	 * 
	 */
	@Override
	public List<WebElement> findElements(final By criteria) {
		LOG.info("find Elements by criteria: " + criteria);
		
		try {
			final FluentWait<WebDriver> fluent = this.createInstanceFluentWait(this.getDriver());
			
			// creating a function that find elements
			final Function<WebDriver, List<WebElement>> function = new Function<WebDriver, List<WebElement>>() {
				public List<WebElement> apply(final WebDriver pDriver) {
					
					final List<WebElement> elementsFound = pDriver.findElements(criteria);
					
					if (elementsFound != null && !elementsFound.isEmpty()) {
						LOG.info("Elements found");
						return elementsFound;
					}
					
					LOG.info("Elements not found");
					return elementsFound;
				}
			};
			
			// waiting element until the element is present or timeout
			return fluent.until(function);
			
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "", e);
			throw new WebElementException("Error finding elements by criteria: " + criteria, e);
		}
	}

	
	/**
	 * Find element by criteria 
	 * 
	 * @param criteria - By
	 * 
	 */
	@Override
	public WebElement findElement(final By criteria) {
		LOG.info("find Element by  criteria: " + criteria);
		
		try {
			final FluentWait<WebDriver> fluent = this.createInstanceFluentWait(this.getDriver());
			
			// creating a function that find element
			final Function<WebDriver, WebElement> function = new Function<WebDriver, WebElement>() {
				public WebElement apply(final WebDriver pDriver) {
					final WebElement element = pDriver.findElement(criteria);
					
					if (element != null) {
						LOG.info("Element found");
						return element;
					}
					
					LOG.info("Element not found");
					return element;
				}
			};
			
			// waiting element until the element is present or timeout
			return fluent.until(function);
			
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "", e);
			throw new WebElementException("Error finding element by criteria: " + criteria, e);
		}
	}
	
	/**
	 * Open web browser and redirect to the specified URL
	 * 
	 * @param url - String
	 */
	@Override
	public void open(final String url) {
		try {
			LOG.info("open URL: " + url);
			this.getDriver().get(url);
			
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "", e);
			throw new WebElementException("Error open browser and redirect to URL: " + url, e);
		}
	}


	/**
	 * navigate to the specified URL
	 * 
	 * @param url - String
	 */
	@Override
	public void navigate(final String url) {
		try {
			LOG.info("navigate to: " + url);
			this.getDriver().navigate().to(url);
			
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "", e);
			throw new WebElementException("Error open browser and redirect to URL: " + url, e);
		}
	}
	
	/**
	 * refresh the current page
	 * 
	 * @param url - String
	 */
	@Override
	public void refresh() {
		try {
			LOG.info("refresh");
			this.getDriver().navigate().refresh();
			
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "", e);
			throw new WebElementException("Error refresh the current page: ", e);
		}
	}
	
	/**
	 * Select by visible text
	 * 
	 * @param element 	- Element
	 * @param text		- String
	 */
	@Override
	public void selectByVisibleText(final WebElement element, final String text) {
		LOG.info("select by visible text: " + text + " element: " + element);
		
		try{
			new Select(element).selectByVisibleText(text);
			
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "", e);
			throw new WebElementException("Error select by visible text: " + element, e);
		}
	}
	
	/**
	 * Select by value
	 * 
	 * @param element 	- Element
	 * @param value		- String
	 */
	@Override
	public void selectByValue(final WebElement element, final String value) {
		LOG.info("select by value: " + value + " element:" + element);
		
		try {
			new Select(element).selectByValue(value);
			
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "", e);
			throw new WebElementException("Error select by value: " + element, e);
		}
	}
	
	/**
	 * Select by index
	 * 
	 * @param element 	- Element
	 * @param index		- int
	 */
	@Override
	public void selectByIndex(final WebElement element, final int index) {
		LOG.info("select by index: " + index + " element: " + element);
		
		try {
			new Select(element).selectByIndex(index);
			
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "", e);
			throw new WebElementException("Error select by index: " + element, e);
		}
	}

	
	/**
	 * get RemoteWebElement
	 * 
	 * @return RemoteWebElement
	 */
	public RemoteWebElement getRemoteWebElement() {
		return remoteWebElement;
	}
	
	/**
	 * Create instance fluent wait
	 * 
	 * @param driver - WebDriver
	 * 
	 * @return FluentWait<WebDriver>
	 */
	private FluentWait<WebDriver> createInstanceFluentWait(final WebDriver driver) {
		return new FluentWait<WebDriver>(driver)
				.withTimeout(DEFAULT_SECONDS_TIMEOUT_FIND_ELEMENT, TimeUnit.SECONDS)
				.pollingEvery(DEFAULT_SECONDS_FREQUENCY_FIND_ELEMENT, TimeUnit.SECONDS)
				.ignoring(WebDriverException.class);
	}
	
	/**
	 * Create instance fluent wait
	 * 
	 * @param driver 	- WebDriver
	 * 
	 * @param timeout 	- int
	 * 
	 * @return FluentWait<WebDriver>
	 */
	private FluentWait<WebDriver> createInstanceFluentWait(final WebDriver driver, final int timeout) {
		return new FluentWait<WebDriver>(driver)
				.withTimeout(timeout, TimeUnit.SECONDS)
				.pollingEvery(DEFAULT_SECONDS_FREQUENCY_FIND_ELEMENT, TimeUnit.SECONDS)
				.ignoring(WebDriverException.class);
	}

	/**
	 * Mouseover event
	 * @param element - WebElement
	 */
	@Override
	public void mouseOver(final WebElement element) {
		LOG.info("Event mouse over: " + element);
		
		try {
			Actions a = new Actions(this.getDriver());
			a.moveToElement(element).build().perform();
				
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "", e);
			throw new WebElementException("Error event mouse over: " + element, e);
		}
	}

	
	/**
	 * Scroll element
	 * @param element - WebElement
	 */
	@Override
	public void scrollIntoView(WebElement element) {
		LOG.info("Scroll in element: " + element);
		
		try {			
			((JavascriptExecutor) this.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "", e);
			throw new WebElementException("Error scroll in element: " + element, e);
		}
		
	}


	/**
	 * Scroll x , y
	 * @param int - positionX 
	 * @param int - positionY
	 */
	@Override
	public void scroll(final int positionX, final int positionY) {
		LOG.info("Scroll X: " + positionX + " Y: " + positionY);
		
		try {			
			((JavascriptExecutor) this.getDriver()).executeScript("window.scroll("+positionX+","+positionY+");");
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "", e);
			throw new WebElementException("Error in Scroll x , y: " , e);
		}
		
	}

	/**
	 * Javascript Executor
	 * @param String javascript
	 */
	@Override
	public void executarJavascript(final String javascript) {
		LOG.info("Executando javascript: " + javascript);
		
		try {			
			((JavascriptExecutor) this.getDriver()).executeScript(javascript);
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "", e);
			throw new WebElementException("Error executando javascript: ", e);
		}		
	}

	/**
	 * Javascript Executor
	 * @param String javascript
	 * @param WebElement element
	 */
	@Override
	public void executarJavascript(final String javascript, final WebElement element) {
		LOG.info("Executando javascript: " + javascript + " element: " + element);
		
		try {			
			((JavascriptExecutor) this.getDriver()).executeScript(javascript, element);
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "", e);
			throw new WebElementException("Error executando javascript: " + element, e);
		}
		
	}


	/**
	 * Wait for element is present
	 * 
	 * @param timeout 	- int
	 * 
	 * @param elements 	- Element
	 * 
	 * @throws ElementNotFoundException - unchecked exception will be throw when element is not present 
	 * 
	 */
	@Override
	public WebElement waitForElementIsPresent(final int timeout, final WebElement element) {
		LOG.info("Wait for element is present");
		
		try {
			final FluentWait<WebDriver> fluent = this.createInstanceFluentWait(this.getDriver(), timeout);
			
			return fluent.until(ExpectedConditions.visibilityOf(element));
			
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "", e);
			throw new ElementNotFoundException("Element is not present in the specified timeout: " + element, e);
		}
	}

	
	/**
	 *  Wait specified element to be clickable and click it.
	 * 
	 * @param element - Element
	 * 
	 * @param timeoutSeconds - int
	 * 
	 */
	@Override
	public void waitAndClick(final WebElement element, final int timeoutSeconds) {
		LOG.info(new StringBuilder("Click element: ").append(element).append(" and wait for: ").append(timeoutSeconds).append(" seconds").toString());
		
		try {
			final FluentWait<WebDriver> fluent = this.createInstanceFluentWait(this.getDriver(), timeoutSeconds);

			final WebElement elementWaiting = fluent.until(ExpectedConditions.elementToBeClickable(element));
			
			elementWaiting.click();
			
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "", e);
			throw new WebElementException("Error on click element: " + element, e);
		}
	}
}