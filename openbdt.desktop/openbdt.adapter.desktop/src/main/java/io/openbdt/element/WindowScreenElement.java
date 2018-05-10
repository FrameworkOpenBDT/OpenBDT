package io.openbdt.element;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.winium.WiniumDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.base.Function;

import io.openbdt.driver.DesktopDriver;
import io.openbdt.exception.WindowElementException;
import io.openbdt.setup.ApplicationWindow;

@Component
public class WindowScreenElement implements WindowView<WindowElement, By, WiniumDriver> {

	private static Logger LOG = Logger.getLogger(WindowScreenElement.class);
	private ApplicationWindow applicationWindow;
	
	@Autowired
	private DesktopDriver driverLoader;

	@Autowired
	public WindowScreenElement(ApplicationWindow applicationWindow) {
		this.applicationWindow = applicationWindow;
	}	
	
	/**
	 * Timeout default
	 */
	public static final long DEFAULT_SECONDS_TIMEOUT_FIND_ELEMENT = 30;

	/**
	 * frequency find element during timeout
	 */
	public static final long DEFAULT_SECONDS_FREQUENCY_FIND_ELEMENT = 5;

	@Override
	public void close() throws Exception {
		this.getDriver().close();
	}

	@Override
	public WiniumDriver getDriver() {
		return this.driverLoader.getDriver();
	}

	/**
	 * Click in the specified web element
	 * 
	 * @param element
	 *            - Window Element
	 * 
	 */
	@Override
	public void click(WindowElement element) {
		try {
			element.getElement().click();
			LOG.info(String.format("click: %s", element));
		} catch (Exception e) {
			LOG.fatal(e.getMessage(), e);
			throw new WindowElementException("Error on click element: " + element, e);
		}
	}

	/**
	 * Click the in the specified elements
	 * 
	 * @param elements
	 *            WindowElement[]
	 * 
	 */
	@Override
	public void click(WindowElement... elements) {
		LOG.info("click list elements");

		try {
			if (elements != null) {
				for (final WindowElement element : elements) {
					this.click(element);
				}
			}
		} catch (WindowElementException e) {
			LOG.fatal(e.getMessage(), e);
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
	public void clickAndWait(WindowElement element, int timeoutSeconds) {
		try {
			final FluentWait<WiniumDriver> fluent = this.createInstanceFluentWait(this.getDriver(), timeoutSeconds);
			ExpectedCondition<WebElement> expectedCondition = ExpectedConditions.visibilityOf(element.getElement());
			final WebElement elementWaiting = fluent.until(expectedCondition);

			elementWaiting.click();
			LOG.info(new StringBuilder("Click element: ").append(element).append(" and wait for: ")
					.append(timeoutSeconds).append(" seconds").toString());
		} catch (Exception e) {
			LOG.fatal(e.getMessage(), e);
			throw new WindowElementException("Error on click element: " + element, e);
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
	@Override
	public void clickAndWait(int timeoutSeconds, WindowElement... elements) {
		LOG.info("click list elements");

		try {
			if (elements != null) {
				for (final WindowElement element : elements) {
					this.clickAndWait(element, timeoutSeconds);
				}
			}
		} catch (WindowElementException e) {
			LOG.fatal(e.getMessage(), e);
			throw e;
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
	public void waitAndClick(WindowElement element, int timeoutSeconds) {
		WebElement innerElement = element.getElement();
		LOG.info(new StringBuilder("Click element: ").append(element).append(" and wait for: ").append(timeoutSeconds)
				.append(" seconds").toString());

		try {
			final FluentWait<WiniumDriver> fluent = this.createInstanceFluentWait(this.getDriver(), timeoutSeconds);

			final WebElement elementWaiting = fluent.until(ExpectedConditions.elementToBeClickable(innerElement));

			elementWaiting.click();

		} catch (Exception e) {
			LOG.fatal(e.getMessage(), e);
			throw new WindowElementException("Error on click element: " + element, e);
		}
	}

	/**
	 * send submit action
	 * 
	 * @param element
	 *            - Window Element
	 * 
	 */
	@Override
	public void submit(WindowElement element) {
		try {
			final FluentWait<WiniumDriver> fluent = this.createInstanceFluentWait(this.getDriver());

			final WebElement btnSubmit = fluent.until(ExpectedConditions.visibilityOf(element.getElement()));

			btnSubmit.submit();
			LOG.info(String.format("submit: %s", element));
		} catch (Exception e) {
			LOG.fatal(e.getMessage(), e);
			throw new WindowElementException("Error on event submit: " + element, e);
		}
	}

	/**
	 * send text to the specified element
	 * 
	 * @param element
	 *            - Window Element
	 * @param textToSend
	 *            - String
	 * 
	 */
	@Override
	public void sendText(WindowElement element, String textToSend) {
		try {
			element.getElement().sendKeys(textToSend);
			LOG.info(String.format("sendText: %s text: %s", element, textToSend));
		} catch (Exception e) {
			LOG.fatal(e.getMessage(), e);
			throw new WindowElementException("Error on event sendkeys: " + element, e);
		}
	}

	/**
	 * clear the specified element
	 * 
	 * @param element
	 *            - Window Element
	 * 
	 */
	@Override
	public void clear(WindowElement element) {
		try {
			element.getElement().clear();
			LOG.info(String.format("clear element: %s", element));
		} catch (Exception e) {
			LOG.fatal(e.getMessage(), e);
			throw new WindowElementException("Error on event clear: " + element, e);
		}
	}

	/**
	 * verify if specified element is selected
	 * 
	 * @param element
	 *            - Window Element
	 * 
	 */
	@Override
	public boolean isSelected(WindowElement element) {
		try {
			WebElement innerElement = element.getElement();
			LOG.info(String.format("is selected: %s", element));
			return innerElement.isSelected();
		} catch (Exception e) {
			LOG.fatal(e.getMessage(), e);
			throw new WindowElementException("Error verifying is selected: " + element, e);
		}
	}

	/**
	 * verify if specified element is enable
	 * 
	 * @param element
	 *            - Window Element
	 * 
	 */
	@Override
	public boolean isEnabled(WindowElement element) {
		try {
			WebElement innerElement = element.getElement();
			LOG.info(String.format("isEnable: %s", element));
			return innerElement.isEnabled();
		} catch (Exception e) {
			LOG.fatal(e.getMessage(), e);
			throw new WindowElementException("Error verifying is enable: " + element, e);
		}
	}
	
	
	/**
	 * verify if specified element is displayed
	 * 
	 * @param element
	 *            - Window Element
	 * 
	 */
	public boolean isDisplayed(WindowElement element) {
		try {
			WebElement innerElement = element.getElement();
			LOG.info(String.format("isEnable: %s", element));
			return innerElement.isDisplayed();
		} catch (Exception e) {
			LOG.fatal(e.getMessage(), e);
			throw new WindowElementException("Error verifying is enable: " + element, e);
		}
	}

	/**
	 * get text in the specified element
	 * 
	 * @param element
	 *            - Window Element
	 * 
	 */
	@Override
	public String getText(WindowElement element) {
		try {
			WebElement innerElement = element.getElement();
			LOG.info(String.format("getText: %s", element));
			return innerElement.getAttribute("Name");
		} catch (Exception e) {
			LOG.fatal(e.getMessage(), e);
			throw new WindowElementException("Error get text: " + element, e);
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
	public List<WindowElement> findElements(By criteria) {
		LOG.info("find Elements by criteria: " + criteria);
		List<WindowElement> elements = new ArrayList<>();
		try {
			final FluentWait<WiniumDriver> fluent = this.createInstanceFluentWait(this.getDriver());

			// creating a function that find elements
			final Function<WiniumDriver, List<WindowElement>> function = (pDriver) -> {
				final List<WebElement> elementsFound = this.applicationWindow.getApplicationWindow().getElement().findElements(criteria);

				if (elementsFound != null && !elementsFound.isEmpty()) {
					LOG.info("Elements found");
					for (WebElement element : elementsFound)
						elements.add(new WindowElement(element, criteria));
					return elements;
				}

				LOG.info("Elements not found");
				return elements;
			};

			// waiting element until the element is present or timeout
			return fluent.until(function);

		} catch (Exception e) {
			LOG.fatal(e.getMessage(), e);
			throw new WindowElementException("Error finding elements by criteria: " + criteria, e);
		}
	}

	/**
	 * Find element by criteria
	 * 
	 * @param criteria - By
	 * 
	 */
	@Override
	public WindowElement findElement(By criteria) {
		LOG.info(String.format("find Element by criteria: %s", criteria));
		try {
			WebElement element = this.applicationWindow.getApplicationWindow().getElement().findElement(criteria);
			return new WindowElement(element, criteria);
		} catch (Exception e) {
			LOG.fatal(e.getMessage(), e);
			throw new WindowElementException("Error finding element by criteria: " + criteria, e);
		}
	}

	/**
	 * Select by visible text
	 * 
	 * @param element
	 *            - Window Element
	 * @param text
	 *            - String
	 */
	@Override
	public void selectByVisibleText(WindowElement element, String text) {
		try {
			Select select = new Select(element.getElement());
			LOG.info(String.format("select by visible text: %s element: %s", text, element));
			select.selectByVisibleText(text);
		} catch (Exception e) {
			LOG.fatal(e.getMessage(), e);
			throw new WindowElementException("Error select by visible text: " + element, e);
		}
	}

	/**
	 * Select by value
	 * 
	 * @param element
	 *            - Window Element
	 * @param value
	 *            - String
	 */
	@Override
	public void selectByValue(WindowElement element, String value) {
		try {
			Select select = new Select(element.getElement());
			LOG.info(String.format("select by value: %s element: %s", value, element));
			select.selectByValue(value);
		} catch (Exception e) {
			LOG.fatal(e.getMessage(), e);
			throw new WindowElementException("Error select by value: " + element, e);
		}
	}

	/**
	 * Select by index
	 * 
	 * @param element
	 *            - Window Element
	 * @param index
	 *            - int
	 */
	@Override
	public void selectByIndex(WindowElement element, int index) {
		try {
			Select select = new Select(element.getElement());
			LOG.info(String.format("select by index: %s element: %s", index, element));
			select.selectByIndex(index);
		} catch (Exception e) {
			LOG.fatal(e.getMessage(), e);
			throw new WindowElementException("Error select by index: " + element, e);
		}
	}

	/**
	 * Create instance fluent wait
	 * 
	 * @param driver
	 *            - Winium driver
	 * 
	 * @param timeout
	 *            - int
	 * 
	 * @return FluentWait<WiniumDriver>
	 */
	private FluentWait<WiniumDriver> createInstanceFluentWait(final WiniumDriver driver, final int timeout) {
		return new FluentWait<WiniumDriver>(driver).withTimeout(timeout, TimeUnit.SECONDS)
				.pollingEvery(DEFAULT_SECONDS_FREQUENCY_FIND_ELEMENT, TimeUnit.SECONDS)
				.ignoring(WebDriverException.class);
	}

	/**
	 * Create instance fluent wait
	 * 
	 * @param driver
	 *            - Mobile driver
	 * 
	 * @return FluentWait<AppiumDriver>
	 */
	private FluentWait<WiniumDriver> createInstanceFluentWait(final WiniumDriver driver) {
		return new FluentWait<WiniumDriver>(driver).withTimeout(DEFAULT_SECONDS_TIMEOUT_FIND_ELEMENT, TimeUnit.SECONDS)
				.pollingEvery(DEFAULT_SECONDS_FREQUENCY_FIND_ELEMENT, TimeUnit.SECONDS)
				.ignoring(WebDriverException.class);
	}
}
