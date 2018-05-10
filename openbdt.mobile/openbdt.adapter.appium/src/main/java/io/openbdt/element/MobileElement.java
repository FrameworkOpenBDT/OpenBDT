package io.openbdt.element;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.openbdt.driver.MobileCustomDriver;

public final class MobileElement {

	private MobileCustomDriver driverSource;
	private By strategy;
	private WebElement element;
	private InnerElement innerElement;
	private Logger LOG = Logger.getLogger(io.openbdt.element.MobileElement.class);
	
	public MobileElement(MobileCustomDriver driverSource, By strategy) {
		this.strategy = strategy;
		this.driverSource = driverSource;
		this.innerElement = () -> {
			// LOG.info(String.format("[%s] Element obtained by driver: %s",
			// this.driver.getCapabilities().getCapability("deviceName"), this.driver));
			this.element = this.driverSource.getAppiumDriver().findElement(this.strategy);
			return this.element;
		};
	}

	public MobileElement(WebElement element) {
		this.element = element;
		this.innerElement = () -> {
			return this.element;
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
		if (this.strategy != null)
			return this.strategy.toString();
		return this.element.toString();
	}
}
