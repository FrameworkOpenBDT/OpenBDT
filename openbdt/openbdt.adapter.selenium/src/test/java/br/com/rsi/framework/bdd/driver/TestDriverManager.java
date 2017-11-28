package br.com.rsi.framework.bdd.driver;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import io.openbdt.driver.WebDriverManager;
import io.openbdt.element.WebBrowserScreenElement;
import io.openbdt.exception.InstantiateDriverException;
import io.openbdt.start.StartApplication;
import io.openbdt.types.SeleniumDriverType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { StartApplication.class, WebDriverManager.class })
public class TestDriverManager {

	@Autowired
	private WebDriverManager driverManager;
	private final Logger LOG = Logger.getLogger(this.getClass());

	@Test
	public void testLoadClassDriver() {

		try (WebBrowserScreenElement ve = (WebBrowserScreenElement) this.driverManager
				.open(SeleniumDriverType.CHROME_DRIVER, null)) {
			ve.getDriver().get("https://www.google.com.br");

			Thread.sleep(10000);

		} catch (InstantiateDriverException e) {
			e.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
