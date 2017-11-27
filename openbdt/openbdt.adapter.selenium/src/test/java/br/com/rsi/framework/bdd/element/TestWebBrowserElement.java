package br.com.rsi.framework.bdd.element;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.rsi.properties.PropertiesAdapterSeleniumUtil;
import io.openbdt.driver.WebDriverManager;
import io.openbdt.element.WebBrowserScreenElement;
import io.openbdt.exception.InstantiateDriverException;
import io.openbdt.exception.PropertyNotFoundException;
import io.openbdt.exception.WebElementException;
import io.openbdt.types.SeleniumDriverType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebDriverManager.class})
public class TestWebBrowserElement {
	
	@Autowired
	private WebDriverManager webDriverManager;
	private final Logger LOG = Logger.getLogger(this.getClass());
	private WebBrowserScreenElement element;
	
	@Before
	public void before() throws InstantiateDriverException, PropertyNotFoundException {
		String driver = FileUtils.getFile(PropertiesAdapterSeleniumUtil.getProperty("webdriver.chrome.driver")).getAbsolutePath();
		System.setProperty("webdriver.chrome.driver", driver);

		this.element = this.webDriverManager.open(SeleniumDriverType.CHROME_DRIVER, null);
		
		final String pathHtmlTest = this.getClass().getResource("/page-test/button.html").getPath();
		
		element.open("file://"+pathHtmlTest);
	}

	@Test
	public void testClickEvent() {
		element.click(element.findElement(By.id("btnId")));
	}
	
	@Test(expected = WebElementException.class)
	public void testClickElementNotFound() {
		element.click(element.findElement(By.name("btnKNoutFound")));
	}
	
	@Test
	public void testSendText() throws InterruptedException {
		element.sendText(element.findElement(By.id("txtTextoID")), "RSI");
	}
	
	@After
	public void afterTests() throws Exception {
		this.element.close();
	}
}
