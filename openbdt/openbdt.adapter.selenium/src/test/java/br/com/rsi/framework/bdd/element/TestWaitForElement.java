package br.com.rsi.framework.bdd.element;

import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import io.openbdt.driver.WebDriverManager;
import io.openbdt.element.WebBrowserScreenElement;
import io.openbdt.exception.ElementNotFoundException;
import io.openbdt.exception.InstantiateDriverException;
import io.openbdt.exception.PropertyNotFoundException;
import io.openbdt.types.SeleniumDriverType;
import io.openbdt.types.TimeoutSegundos;
import jline.internal.Log;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebDriverManager.class})
public class TestWaitForElement {

	@Autowired
	private WebDriverManager webDriverManager;
	private final Logger LOG = Logger.getLogger(this.getClass());
	private WebBrowserScreenElement element;
	
	@Before
	public void before() throws InstantiateDriverException, PropertyNotFoundException {
		this.element = this.webDriverManager.open(SeleniumDriverType.CHROME_DRIVER, null);
		
		final String pathHtmlTest = this.getClass().getResource("/page-test/elements.html").getPath();
		
		element.open("file://"+pathHtmlTest);
	}
	
	
	@Test
	public void testElementIsPresent() {
		WebElement elementPresent = element.waitForElementIsPresent(TimeoutSegundos.CINCO_SEGUNDOS.getTimeoutSegundos(), element.findElement(By.id("tab1")));
		
		Assert.assertNotNull(elementPresent);
	}
	
	@Test(expected = ElementNotFoundException.class)
	public void testElementIsNotPresent() {
		WebElement webEmptyElement = new WebElement() {
			
			@Override
			public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void submit() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void sendKeys(CharSequence... keysToSend) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean isSelected() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isEnabled() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isDisplayed() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public String getText() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getTagName() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Dimension getSize() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Rectangle getRect() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Point getLocation() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getCssValue(String propertyName) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getAttribute(String name) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public List<WebElement> findElements(By by) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public WebElement findElement(By by) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void click() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void clear() {
				// TODO Auto-generated method stub
				
			}
		};
		
		element.waitForElementIsPresent(TimeoutSegundos.CINCO_SEGUNDOS.getTimeoutSegundos(), webEmptyElement);
	}
	
	
	@After
	public void afterTests() throws Exception {
		
		this.element.close();
	}
}
