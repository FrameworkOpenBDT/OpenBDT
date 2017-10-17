package br.com.rsi.framework.bdd.element;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import io.openbdt.driver.WebDriverManager;
import io.openbdt.element.WebBrowserScreenElement;
import io.openbdt.exception.InstantiateDriverException;
import io.openbdt.exception.WebElementException;
import io.openbdt.types.SeleniumDriverType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebDriverManager.class})
public class TestWebBrowserElementMouseOverFireFox {
	
	@Autowired
	private WebDriverManager webDriverManager;
	
	private WebBrowserScreenElement element;
	
	@Before
	public void before() throws InstantiateDriverException {
		final String geckoDriver = "C:/desenvolvimento/tools/chrome/chromedriver.exe";
		
		System.setProperty("webdriver.gecko.driver", geckoDriver);
		
		this.element = this.webDriverManager.open(SeleniumDriverType.FIREFOX_DRIVER, null);
		
		final String pathHtmlTest = this.getClass().getResource("/page-test/testwebbrowsermouseover.html").getPath();
		
		element.open("file://"+pathHtmlTest);
	}

	@Test
	public void testMouseOverEvent() {
		element.mouseOver(element.findElement(By.className("dropdown")));
	}
	
	@Test(expected = WebElementException.class)
	public void testMouseOverEventNotFound() {
		element.mouseOver(element.findElement(By.className("drosssspdown")));
	}
	
	@After
	public void afterTests() throws Exception {
		this.element.close();
	}
}
