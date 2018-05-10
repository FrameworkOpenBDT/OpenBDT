package io.openbdt.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.winium.WiniumDriver;

public final class WindowElement {

	private WiniumDriver driver;
	private By strategy;
	private WebElement element;
	private InnerElement innerElement;
	private WindowElement applicationView;

	public WindowElement(WiniumDriver driver, By strategy) {
		this.strategy = strategy;
		this.driver = driver;
		this.innerElement = () -> {
			this.element = this.driver.findElement(this.strategy);
			return this.element;
		};
	}
	
	public WindowElement(WindowElement applicationView, By strategy) {
		this.strategy = strategy;
		this.applicationView = applicationView;
		this.innerElement = () -> {
			this.element = this.applicationView.getElement().findElement(this.strategy);
			return this.element;
		};
	}

	public WindowElement(WebElement element, By strategy) {
		this.element = element;
		this.strategy = strategy;
		this.innerElement = () -> {
			return element;
		};
	}

	public WebElement getElement() {
		return this.innerElement.getElement();
	}

	private interface InnerElement {
		WebElement getElement();
	}

	@Override
	public String toString() {
		return this.strategy.toString();
	}
}
