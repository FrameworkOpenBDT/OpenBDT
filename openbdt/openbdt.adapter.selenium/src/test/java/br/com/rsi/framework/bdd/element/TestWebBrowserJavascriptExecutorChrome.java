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
public class TestWebBrowserJavascriptExecutorChrome {
	
	@Autowired
	private WebDriverManager webDriverManager;
	private final Logger LOG = Logger.getLogger(this.getClass());
	private WebBrowserScreenElement element;
	
	@Before
	public void before() throws InstantiateDriverException, PropertyNotFoundException {
		String driver = FileUtils.getFile(PropertiesAdapterSeleniumUtil.getProperty("webdriver.chrome.driver")).getAbsolutePath();
		System.setProperty("webdriver.chrome.driver", driver);

		this.element = this.webDriverManager.open(SeleniumDriverType.CHROME_DRIVER, null);
		
		final String pathHtmlTest = this.getClass().getResource("/page-test/testwebjavascriptexecutor.html").getPath();
		
		element.open("file://"+pathHtmlTest);
	}

	@Test
	public void testJavascriptExecutor() {
		element.executarJavascript("console.log('Teste executando Javasript')");
	}
	
	
	@Test
	public void testJavascriptExecutorElement() {
		element.executarJavascript("arguments[0].click();", element.findElement(By.id("myPopup")));
	}

	@Test(expected = WebElementException.class)
	public void testJavascriptExecutorSyntaxError() {
		element.executarJavascript("alert('Teste executando Javascript");
	}

	@Test(expected = WebElementException.class)
	public void testJavascriptExecutorElementNotFound() {
		element.executarJavascript("arguments[0].click();", element.findElement(By.id("x124")));
	}
	
	@After
	public void afterTests() throws Exception {
		this.element.close();
	}
}
