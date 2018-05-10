package io.openbdt.setup;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;

import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.openbdt.driver.DesktopDriver;
import io.openbdt.element.WindowElement;
import io.openbdt.exception.WindowApplicationPropertyNotFoundException;

@Component
public class ApplicationWindow {
	
	private DesktopDriver driver;
	private BufferedReader br;
	private Matcher matcher;
	private Pattern pattern;
	private WindowElement applicationWindow;
	
	@Autowired
	public ApplicationWindow(DesktopDriver driver) throws FileNotFoundException {
		this.driver = driver;
		br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("thucydides.properties"))));
		pattern = Pattern.compile("^window\\.application\\.(.*)=(.*)$");
	}
	
	@PostConstruct
	public void init() throws IOException {
		String lineRead = null;
		while((lineRead = br.readLine()) != null) {
			this.matcher = this.pattern.matcher(lineRead);
			if(this.matcher.matches()) {
				String strategy = this.matcher.group(1);
				String using = this.matcher.group(2);
				if(strategy.equalsIgnoreCase("name")) {
					this.applicationWindow = new WindowElement(this.driver.getDriver(), By.name(using));
					break;
				}else if(strategy.equalsIgnoreCase("id")) {
					this.applicationWindow = new WindowElement(this.driver.getDriver(), By.id(using));
					break;
				}else if(strategy.equalsIgnoreCase("xpath")) {
					this.applicationWindow = new WindowElement(this.driver.getDriver(), By.xpath(using));
					break;
				}else if(strategy.equalsIgnoreCase("class_name")) {
					this.applicationWindow = new WindowElement(this.driver.getDriver(), By.className(using));
					break;
				}else {
					throw new WindowApplicationPropertyNotFoundException("'window.application.<strategy>=<value>' not found in thucydides.properties'");
				}
			}
		}
	}
	
	public WindowElement getApplicationWindow() {
		return this.applicationWindow;
	}
}