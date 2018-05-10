package io.openbdt.strategy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.FindsByName;
import org.openqa.selenium.internal.FindsByXPath;

/**
 * 
 * @author splait
 *
 */
public final class CustomDesktopByName extends By {

	private String name;
	
	public CustomDesktopByName(String name) {
		this.name = name;
	}
	
	@Override
	public List<WebElement> findElements(SearchContext context) {
	      if (context instanceof FindsByName)
	          return ((FindsByName) context).findElementsByName(name);
	        return ((FindsByXPath) context).findElementsByXPath(".//*[@Name = '"
	            + name + "']");
	}
	
	@Override
	public WebElement findElement(SearchContext context) {
	      if (context instanceof FindsByName)
	          return ((FindsByName) context).findElementByName(name);
	        return ((FindsByXPath) context).findElementByXPath(".//*[@Name = '"
	            + name + "']");
	}
	
	@Override
	public String toString() {
		return "By.name: " + name;
	}
}
