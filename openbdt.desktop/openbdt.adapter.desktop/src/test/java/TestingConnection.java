import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.openqa.selenium.winium.WiniumDriverService;

public class TestingConnection {

	@Test
	public void testConnection() throws MalformedURLException {
		WiniumDriverService service = new WiniumDriverService.Builder()
                .usingDriverExecutable(new File("src/test/resources/Winium.Desktop.Driver.exe").getAbsoluteFile())
                .usingPort(9999)
                .withVerbose(true)
                .withSilent(false)
                .buildDesktopService();
		try {
			DesktopOptions options = new DesktopOptions();
			options.setApplicationPath("C:\\Windows\\System32\\notepad.exe");
			//WiniumDriver driver = new WiniumDriver(new URL("http://localhost:9999"), options);
			//WiniumDriver driver = new WiniumDriver(options);
			//service.start();
			WiniumDriver driver = new WiniumDriver(service, options);
			//driver.findElement(By.xpath("//ControlType.Button[@AutomationId='num3Button']")).click();
			//driver.findElement(By.xpath("//Button[@AutomationId='num3Button']")).click();
			WebElement application = driver.findElement(By.className("Notepad"));
			//application.findElement(By.id("Item 5")).click();
			application.findElement(By.id("Item 2")).click();
			//application.findElement(By.id("Item 65")).click();
			//application.findElement(By.name("OK")).click();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
