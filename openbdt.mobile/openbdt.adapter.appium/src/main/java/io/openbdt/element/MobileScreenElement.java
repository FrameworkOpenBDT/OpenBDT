package io.openbdt.element;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.base.Function;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.openbdt.driver.MobileCustomDriver;
import io.openbdt.exception.ElementNotFoundException;
import io.openbdt.exception.MobileElementException;

/**
 * functions to interact with the mobile screen
 * 
 * @author splait
 */

public class MobileScreenElement
		//implements AppElement<MobileElement, By, AppiumDriver<io.appium.java_client.MobileElement>> {
		implements AppElement<MobileElement, By, WebDriver> {

	/**
	 * Device serial number
	 */
	private String udid;

/*	*//**
	 * Driver container
	 *//*
	private MobileDriverSupport mobileDriverSupport;
	private AppiumDriver<io.appium.java_client.MobileElement> driver;
	*/
	
	/**
	 * Driver custom
	 */
	@Autowired
	private MobileCustomDriver mobileCustomDriver;

	/**
	 * LOG
	 */
	private Logger LOG = Logger.getLogger(MobileScreenElement.class.getName());

	/**
	 * Timeout default
	 */
	public static final long DEFAULT_SECONDS_TIMEOUT_FIND_ELEMENT = 30;

	/**
	 * frequency find element during timeout
	 */
	public static final long DEFAULT_SECONDS_FREQUENCY_FIND_ELEMENT = 5;

/*	*//**
	 * 
	 * @param udidMobile
	 *            serial number
	 * @param mobileDriverSupport
	 *            mobile Driver Support
	 * 
	 *//*
	public MobileScreenElement(String udid, MobileDriverSupport mobileDriverSupport) {
		this.udid = udid;
		this.mobileDriverSupport = mobileDriverSupport;
	}*/
	
	
//	/**
//	 * 
//	 * @param udidMobile
//	 *            serial number
//	 * @param mobileDriverSupport
//	 *            mobile Driver Support
//	 * 
//	 */
//	@Autowired
//	public MobileScreenElement(MobileCustomDriver mobileCustomDriver) {
//		this.udid = mobileCustomDriver.getUdid();
//		this.mobileCustomDriver = mobileCustomDriver;
//	}
	
	@PostConstruct
	private void init() {
		this.udid = this.mobileCustomDriver.getUdid();
	}
	
	/**
	 * Get the current driver
	 * 
	 * @return Mobile driver
	 */
	public AppiumDriver<io.appium.java_client.MobileElement> getDriver() {
		return this.mobileCustomDriver.getAppiumDriver();
	}

	/**
	 * Close the current connection
	 * 
	 * @throws Exception
	 */
	@Override
	public void close() throws Exception {
		LOG.info(String.format("[%s] closing app and current driver", this.udid));
		this.getDriver().closeApp();
		this.getDriver().quit();
		//this.mobileDriverSupport.removeDriver(this.udid);
	}

	public String getUdid() {
		return udid;
	}

	public void setUdid(String udid) {
		this.udid = udid;
	}

	/**
	 * Click in the specified web element
	 * 
	 * @param element
	 *            - Mobile Element
	 * 
	 */
	@Override
	public void click(final MobileElement element) {
		try {
			WebElement innerElement = element.getElement();
			LOG.info(String.format("[%s] {click: %s}", this.udid, element));
			innerElement.click();
			//verifyClick(element);
		} catch (Exception e) {
			LOG.fatal(String.format("[%s] could not click on element: %s", this.udid, element), e);
			throw new MobileElementException(String.format("[%s] could not click on element: %s", this.udid, element), e);
		}
	}

	private void verifyClick(final MobileElement element) {
		getDriver().manage().timeouts().implicitlyWait(1500, TimeUnit.MILLISECONDS);
		try {
			if (element.getElement().isDisplayed()) {
				element.getElement().click();
				LOG.info(String.format("[%s] {dual click: [%s]}", this.udid, element));
			}
		} catch (Exception e) {
			LOG.info(String.format("[%s] {click verified: [%s]}", this.udid, element));
		} finally {
			getDriver().manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
		}
	}

	/**
	 * Click the in the specified elements
	 * 
	 * @param MobileElement[]
	 * 
	 */
	@Override
	public void click(final MobileElement... elements) {
		LOG.info(String.format("[%s] click list elements", this.udid));

		try {
			if (elements != null) {
				for (final MobileElement element : elements) {
					this.click(element);
				}
			}
		} catch (MobileElementException e) {
			throw e;
		}
	}

	/**
	 * Click the element and wait specified time if element is not visible
	 * 
	 * @param element
	 *            - Element
	 * 
	 * @param timeoutSeconds
	 *            - int
	 * 
	 */
	@Override
	public void clickAndWait(final MobileElement element, final int timeoutSeconds) {
		try {
			final FluentWait<WebDriver> fluent = this
					.createInstanceFluentWait(this.getDriver(), timeoutSeconds);

			final io.appium.java_client.MobileElement elementWaiting = (io.appium.java_client.MobileElement) fluent
					.until(ExpectedConditions.visibilityOf(element.getElement()));
			LOG.info(String.format("[%s] {click in element %s and wait %d seconds}", this.udid, element, timeoutSeconds));
			elementWaiting.click();
		} catch (Exception e) {
			LOG.fatal(String.format("[%s] could not click on element %s and wait %d seconds", this.udid, element, timeoutSeconds), e);
			throw new MobileElementException(String.format("[%s] could not click on element %s and wait %d seconds", this.udid, element, timeoutSeconds), e);
		}
	}

	/**
	 * Click the elements and wait specified time if element is not visible
	 * 
	 * @param timeoutSeconds
	 *            - int
	 * 
	 * @param elements
	 *            - Element[]
	 * 
	 */
	public void clickAndWait(final int timeoutSeconds, final MobileElement... elements) {
		LOG.info("click list elements");

		try {
			if (elements != null) {
				for (final MobileElement element : elements) {
					this.clickAndWait(element, timeoutSeconds);
				}
			}
		} catch (MobileElementException e) {
			LOG.fatal(e.getMessage(), e);
			throw e;
		}
	}

	/**
	 * send submit action
	 * 
	 * @param element
	 *            - Mobile Element
	 * 
	 */
	@Override
	public void submit(final MobileElement element) {
		try {
			final FluentWait<WebDriver> fluent = this
					.createInstanceFluentWait(this.getDriver());

			final io.appium.java_client.MobileElement btnSubmit = (io.appium.java_client.MobileElement) fluent
					.until(ExpectedConditions.visibilityOf(element.getElement()));
			LOG.info(String.format("[%s] {submit: %s}", this.udid, element));
			btnSubmit.submit();
		} catch (Exception e) {
			LOG.fatal(String.format("[%s] %s", this.udid, element), e);
			throw new MobileElementException(String.format("[%s] Error on event submit: %s", this.udid, element), e);
		}
	}

	/**
	 * send text to the specified element
	 * 
	 * @param element
	 *            - Mobile Element
	 * @param textToSend
	 *            - String
	 * 
	 */
	@Override
	public void sendText(final MobileElement element, final String textToSend) {
		try {
			WebElement innerElement = element.getElement();
			LOG.info(String.format("[%s] {sendText: %s text: %s}", this.udid, element, textToSend));
			innerElement.sendKeys(textToSend);
			//((HidesKeyboard)getDriver()).hideKeyboard();
			getDriver().navigate().back();
		} catch (Exception e) {
			LOG.fatal(String.format("[%s] %s", this.udid, e), e);
			throw new MobileElementException(String.format("[%s] Error on event sendkeys: %s", this.udid, element), e);
		}
	}

	/**
	 * clear the specified element
	 * 
	 * @param element
	 *            - Mobile Element
	 * 
	 */
	@Override
	public void clear(final MobileElement element) {
		try {
			element.getElement().clear();
			LOG.info(String.format("[%s] {clear element: %s}", this.udid, element));
		} catch (Exception e) {
			LOG.fatal(String.format("[%s] %s", this.udid, element), e);
			throw new MobileElementException(String.format("[%s] Error on event clear: %s", this.udid, element), e);
		}
	}

	/**
	 * verify if specified element is selected
	 * 
	 * @param element
	 *            - Mobile Element
	 * 
	 */
	@Override
	public boolean isSelected(final MobileElement element) {
		try {
			WebElement innerElement = element.getElement();
			LOG.info(String.format("[%s] {is selected: %s}", this.udid, element));
			return innerElement.isSelected();
		} catch (Exception e) {
			LOG.fatal(String.format("[%s] %s", this.udid, element), e);
			throw new MobileElementException(String.format("[%s] Error verifying is selected: ", this.udid, element),
					e);
		}
	}

	/**
	 * verify if specified element is enable
	 * 
	 * @param element
	 *            - Mobile Element
	 * 
	 */
	@Override
	public boolean isEnabled(final MobileElement element) {
		try {
			WebElement innerElement = element.getElement();
			LOG.info(String.format("[%s] {isEnable: %s}", this.udid, element));
			return innerElement.isEnabled();
		} catch (Exception e) {
			LOG.fatal(String.format("[%s] %s", this.udid, element), e);
			throw new MobileElementException(String.format("[%s] Error verifying is enable: ", this.udid, element), e);
		}
	}

	/**
	 * get text in the specified element
	 * 
	 * @param element
	 *            - Mobile Element
	 * 
	 */
	@Override
	public String getText(final MobileElement element) {
		try {
			WebElement innerElement = element.getElement();
			LOG.info(String.format("[%s] {getText: %s}", this.udid, element));
			return innerElement.getText();
		} catch (Exception e) {
			LOG.fatal(String.format("[%s] %s", this.udid, element), e);
			throw new MobileElementException("Error get text: " + element, e);
		}
	}

	/**
	 * Find elements by criteria
	 * 
	 * @param criteria
	 *            - By
	 * 
	 */
	@Override
	public List<io.openbdt.element.MobileElement> findElements(final By criteria) {
		LOG.info("find Elements by criteria: " + criteria);
		List<MobileElement> elements = new ArrayList<>();
		try {
			final FluentWait<WebDriver> fluent = this
					.createInstanceFluentWait(this.getDriver());

			// creating a function that find elements
			final Function<WebDriver, List<MobileElement>> function = (
					pDriver) -> {

				// final List<MobileElement> elements = new ArrayList<>();
				final List<WebElement> elementsFound = pDriver.findElements(criteria);

				if (elementsFound != null && !elementsFound.isEmpty()) {
					LOG.info("Elements found");
					for (WebElement element : elementsFound)
						elements.add(new MobileElement(element));
					return elements;
				}

				LOG.warn("Elements not found");
				return elements;
			};

			// waiting element until the element is present or timeout
			return fluent.until(function);

		} catch (Exception e) {
			LOG.fatal(e.getMessage(), e);
			throw new MobileElementException("Error finding elements by criteria: " + criteria, e);
		}
	}

	/**
	 * Find element by criteria
	 * 
	 * @param criteria
	 *            - By
	 * 
	 */
	@Override
	public io.openbdt.element.MobileElement findElement(final By criteria) {
		LOG.info(String.format("[%s] {find Element by criteria: %s}", this.udid, criteria));
		try {
			final FluentWait<WebDriver> fluent = this
					.createInstanceFluentWait(this.getDriver());

			// creating a function that find element
			final Function<WebDriver, io.openbdt.element.MobileElement> function = pDriver -> {
				final WebElement element = pDriver.findElement(criteria);

				if (element != null) {
					LOG.info(String.format("[%s] Element found: %s", this.udid, element));
					return new MobileElement(element);
				}

				LOG.info(String.format("[%s] Element not found", this.udid));
				return new MobileElement(element);
			};

			// waiting element until the element is present or timeout
			return fluent.until(function);

		} catch (Exception e) {
			LOG.fatal(String.format("[%s] %s", this.udid, e), e);
			throw new MobileElementException("Error finding element by criteria: " + criteria, e);
		}
	}

	/**
	 * Select by visible text
	 * 
	 * @param element
	 *            - Element
	 * @param text
	 *            - String
	 */
	@Override
	public void selectByVisibleText(final MobileElement element, final String text) {
		try {
			Select select = new Select(element.getElement());
			LOG.info(String.format("[%s] {select by visible text: %s element: %s}", this.udid, text, element));
			select.selectByVisibleText(text);
		} catch (Exception e) {
			LOG.fatal(String.format("[%s] Error select by visible text: %s", this.udid, text), e);
			throw new MobileElementException(String.format("[%s] Error select by visible text: %s", this.udid, text),
					e);
		}
	}

	/**
	 * Select by value
	 * 
	 * @param element
	 *            - Mobile Element
	 * @param value
	 *            - String
	 */
	@Override
	public void selectByValue(final MobileElement element, final String value) {
		try {
			Select select = new Select(element.getElement());
			LOG.info(String.format("[%s] {select by value: %s element: %s}", this.udid, value, element));
			select.selectByValue(value);
		} catch (Exception e) {
			LOG.fatal(String.format("[%s] Could not select by value: %s", this.udid, value), e);
			throw new MobileElementException(String.format("[%s] Could not select by value: %s", this.udid, value), e);
		}
	}

	/**
	 * Select by index
	 * 
	 * @param element
	 *            - Mobile Element
	 * @param index
	 *            - int
	 */
	@Override
	public void selectByIndex(final MobileElement element, final int index) {
		try {
			Select select = new Select(element.getElement());
			LOG.info(String.format("[%s] {select by index: %s element: %s}", this.udid, index, element));
			select.selectByIndex(index);
		} catch (Exception e) {
			LOG.fatal(String.format("[%s] Could not select by index: %s", this.udid, index), e);
			throw new MobileElementException(String.format("[%s] Could not select by index: %s", this.udid, index), e);
		}
	}

	/**
	 * Create instance fluent wait
	 * 
	 * @param webDriver
	 *            - Mobile driver
	 * 
	 * @return FluentWait<AppiumDriver>
	 */
	private FluentWait<WebDriver> createInstanceFluentWait(
			final WebDriver webDriver) {
		return new FluentWait<WebDriver>(webDriver)
				.withTimeout(DEFAULT_SECONDS_TIMEOUT_FIND_ELEMENT, TimeUnit.SECONDS)
				.pollingEvery(DEFAULT_SECONDS_FREQUENCY_FIND_ELEMENT, TimeUnit.SECONDS)
				.ignoring(WebDriverException.class);
	}

	/**
	 * Create instance fluent wait
	 * 
	 * @param webDriver
	 *            - Mobile driver
	 * 
	 * @param timeout
	 *            - int
	 * 
	 * @return FluentWait<AppiumDriver>
	 */
	private FluentWait<WebDriver> createInstanceFluentWait(
			final WebDriver webDriver, final int timeout) {
		return new FluentWait<WebDriver>(webDriver)
				.withTimeout(timeout, TimeUnit.SECONDS)
				.pollingEvery(DEFAULT_SECONDS_FREQUENCY_FIND_ELEMENT, TimeUnit.SECONDS)
				.ignoring(WebDriverException.class);
	}

	/**
	 * Scroll element
	 * 
	 * @param element
	 *            - Mobile Element
	 */
	@Override
	public void scrollIntoView(MobileElement element) {
		try {
			((JavascriptExecutor) this.getDriver()).executeScript("arguments[0].scrollIntoView(true);",
					element.getElement());
			LOG.info(String.format("[%s] {scroll into the element: %s}", this.udid, element));
		} catch (Exception e) {
			LOG.fatal(String.format("[%s] Error scroll in element: %s", element), e);
			throw new MobileElementException(String.format("[%s] Error scroll in element: %s", element), e);
		}

	}

	/**
	 * Scroll x , y
	 * 
	 * @param int
	 *            - positionX
	 * @param int
	 *            - positionY
	 */
	@Override
	public void scroll(final int positionX, final int positionY) {
		LOG.info(String.format("[%s] {scroll (%d, %d)}", positionX, positionY));

		try {
			((JavascriptExecutor) this.getDriver())
					.executeScript("window.scroll(" + positionX + "," + positionY + ");");
		} catch (Exception e) {
			LOG.fatal(String.format("[%s] %s", this.udid, e), e);
			throw new MobileElementException("Error in Scroll x , y: ", e);
		}

	}

	/**
	 * Javascript Executor
	 * 
	 * @param String
	 *            javascript
	 */
	@Override
	public void executarJavascript(final String javascript) {
		LOG.info(String.format("[%s] {running javascript: %s}", this.udid, javascript));
		try {
			((JavascriptExecutor) this.getDriver()).executeScript(javascript);
		} catch (Exception e) {
			LOG.fatal(String.format("[%s] error in javascript execution command: %s", this.udid, javascript), e);
			throw new MobileElementException(
					String.format("[%s] error in javascript execution command: %s", this.udid, javascript), e);
		}
	}

	/**
	 * Javascript Executor
	 * 
	 * @param String
	 *            javascript
	 * @param MobileElement
	 *            element
	 */
	@Override
	public void executarJavascript(final String javascript, final MobileElement element) {
		try {
			((JavascriptExecutor) this.getDriver()).executeScript(javascript, element.getElement());
			LOG.info(String.format("[%s] {running javascript: %s in element: %s}", this.udid, javascript, element));
		} catch (Exception e) {
			LOG.fatal(String.format("[%s] error in javascript execution: %s in element: %s", this.udid, javascript,
					element));
			throw new MobileElementException(String.format("[%s] error in javascript execution: %s in element: %s",
					this.udid, javascript, element), e);
		}

	}

	/**
	 * Wait for element is present
	 * 
	 * @param timeout
	 *            - int
	 * 
	 * @param elements
	 *            - Element
	 * 
	 * @throws ElementNotFoundException
	 *             - unchecked exception will be throw when element is not present
	 * 
	 */
	@Override
	public MobileElement waitForElementIsPresent(final int timeout, final MobileElement element) {
		try {
			WebElement innerElement = element.getElement();
			LOG.info(String.format("[%s] {waiting for element: %s}", this.udid, element));
			final FluentWait<WebDriver> fluent = this
					.createInstanceFluentWait(this.getDriver(), timeout);
			return new MobileElement(
					(io.appium.java_client.MobileElement) fluent.until(ExpectedConditions.visibilityOf(innerElement)));

		} catch (Exception e) {
			LOG.fatal(String.format("[%s] Element is not present in the specified timeout: %s", this.udid, element), e);
			throw new ElementNotFoundException(
					String.format("[%s] Element is not present in the specified timeout: %s", this.udid, timeout, e),
					e);
		}
	}

	/**
	 * Wait specified element to be clickable and click it.
	 * 
	 * @param element
	 *            - Element
	 * 
	 * @param timeoutSeconds
	 *            - int
	 * 
	 */
	@Override
	public void waitAndClick(final MobileElement element, final int timeoutSeconds) {
		WebElement innerElement = element.getElement();
		LOG.info(String.format("[%s] {wait %d seconds and click in element: %s}", this.udid, timeoutSeconds, element));
		try {
			final FluentWait<WebDriver> fluent = this
					.createInstanceFluentWait(this.getDriver(), timeoutSeconds);

			final io.appium.java_client.MobileElement elementWaiting = (io.appium.java_client.MobileElement) fluent
					.until(ExpectedConditions.elementToBeClickable(innerElement));

			elementWaiting.click();

		} catch (Exception e) {
			LOG.fatal(String.format("[%s] wait and click was not successfully executed", this.udid, element), e);
			throw new MobileElementException(
					String.format("[%s] wait and click was not successfully executed", this.udid), e);
		}
	}

	public void swipeUntilElementIsvisible(MobileElement element) {
		WebElement innerElement = element.getElement();
		LOG.info(String.format("[%s] {swipe until element is visible: %s}", this.udid, element));
		Point center = ((io.appium.java_client.MobileElement) innerElement).getCenter();
		int screenHeight = getDriver().manage().window().getSize().getWidth();
		int initialYPoint = (int) (screenHeight - (screenHeight * 0.2f));
		int finalYPoint = (int) (initialYPoint - (initialYPoint * 0.25f));
		TouchAction action = new TouchAction(getDriver());
		while (!innerElement.isDisplayed())
			action.press(center.x, initialYPoint).moveTo(center.x, finalYPoint).release().perform();
			//action.down(center.x, initialYPoint).move(center.x, finalYPoint).release().perform();
	}

	public boolean isDisplayed(MobileElement element) {
		WebElement innerElement = element.getElement();
		LOG.info(String.format("[%s] {is displayed: %s}", this.udid, element));
		return innerElement.isDisplayed();
	}
}