package io.openbdt.mapping;

import java.io.IOException;
import java.lang.reflect.Field;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.winium.WiniumDriver;
import org.springframework.beans.factory.annotation.Autowired;

import io.openbdt.driver.DesktopDriver;
import io.openbdt.element.WindowElement;
import io.openbdt.element.annotions.ApplicationView;
import io.openbdt.element.annotions.SplashWindow;
import io.openbdt.element.annotions.WindowAlert;
import io.openbdt.exception.AnUniqueApplicationViewIsRequiredException;
import io.openbdt.exception.ApplicationViewIsRequiredException;
import io.openbdt.exception.StrategyNotPassedException;
import io.openbdt.exception.StrategyNotSupportedException;
import io.openbdt.setup.ApplicationWindow;
import io.openbdt.strategy.CustomDesktopByName;

/**
 * Desktop window object class
 * 
 * @author splait
 *
 */
public class WindowObject{

	private static Logger LOG = Logger.getLogger(WindowObject.class);
	private WindowElement applicationView;
	
	@Autowired
	protected DesktopDriver desktopDriver;
	
	@Autowired
	private ApplicationWindow applicationWindow;
	
	@PostConstruct
	public void initElements() throws IllegalArgumentException, IllegalAccessException, StrategyNotSupportedException,
			ApplicationViewIsRequiredException, AnUniqueApplicationViewIsRequiredException, IOException {
		
		Field[] fields = this.getClass().getDeclaredFields();
		this.applicationView = this.applicationWindow.getApplicationWindow();
		for (int i = 0; i < fields.length; i++) {
			if (fields[i].isAnnotationPresent(FindBy.class)) {
				FindBy annotation = null;
				annotation = fields[i].getAnnotation(FindBy.class);
				fields[i].set(this, createWindowElement(this.applicationView, annotation));
				LOG.info(String.format("Instance set to %s.%s", this.getClass().getName(), fields[i].getName()));
			}else if(fields[i].isAnnotationPresent(SplashWindow.class)) {
				SplashWindow annotation = null;
				annotation = fields[i].getAnnotation(SplashWindow.class);
				fields[i].set(this, createWindowElement(desktopDriver.getDriver(), annotation));
				LOG.info(String.format("[SPLASH] Instance set to %s.%s", this.getClass().getName(), fields[i].getName()));
			}else if(fields[i].isAnnotationPresent(WindowAlert.class)) {
				WindowAlert annotation = null;
				annotation = fields[i].getAnnotation(WindowAlert.class);
				fields[i].set(this, createWindowElement(desktopDriver.getDriver(), annotation));
				LOG.info(String.format("[WINDOW ALERT] Instance set to %s.%s", this.getClass().getName(), fields[i].getName()));
			}
		}
	}

	private Object createWindowElement(WiniumDriver driver, WindowAlert annotation) {
		return this.createIndependentWindowViewElement(driver, annotation);
	}

	private Object createIndependentWindowViewElement(WiniumDriver driver, WindowAlert annotation) {
		WindowElement element = null;
		switch (annotation.how()) {
		case ID: {
			element = new WindowElement(driver, By.id(annotation.using()));
			LOG.info(String.format("Window element instanciated [strategy: id{%s}]", annotation.using()));
			return element;
		}
		case XPATH: {
			element = new WindowElement(driver, By.xpath(annotation.using()));
			LOG.info(String.format("Window element instanciated [strategy: xpath{%s}]", annotation.using()));
			return element;
		}
		case NAME: {
			element = new WindowElement(driver, new CustomDesktopByName(annotation.using()));
			LOG.info(String.format("Window element instanciated [strategy: name{%s}]", annotation.using()));
			return element;
		}
		case CLASS_NAME: {
			element = new WindowElement(driver, By.className(annotation.using()));
			LOG.info(String.format("Window element instanciated [strategy: class-name{%s}]", annotation.using()));
			return element;
		}
		case UNSET:
			throw new StrategyNotPassedException("A strategy must be informed in FindBy annotation");
		default:
			throw new StrategyNotSupportedException(String.format("'%s' strategy not supported", annotation.using()));
		}
	}

	private Object createWindowElement(WiniumDriver driver, SplashWindow annotation) {
		return this.createIndependentWindowViewElement(driver, annotation);
	}

	private Object createIndependentWindowViewElement(WiniumDriver driver, SplashWindow annotation) {
		WindowElement element = null;
		switch (annotation.how()) {
		case ID: {
			element = new WindowElement(driver, By.id(annotation.using()));
			LOG.info(String.format("Window element instanciated [strategy: id{%s}]", annotation.using()));
			return element;
		}
		case XPATH: {
			element = new WindowElement(driver, By.xpath(annotation.using()));
			LOG.info(String.format("Window element instanciated [strategy: xpath{%s}]", annotation.using()));
			return element;
		}
		case NAME: {
			element = new WindowElement(driver, new CustomDesktopByName(annotation.using()));
			LOG.info(String.format("Window element instanciated [strategy: name{%s}]", annotation.using()));
			return element;
		}
		case CLASS_NAME: {
			element = new WindowElement(driver, By.className(annotation.using()));
			LOG.info(String.format("Window element instanciated [strategy: class-name{%s}]", annotation.using()));
			return element;
		}
		case UNSET:
			throw new StrategyNotPassedException("A strategy must be informed in FindBy annotation");
		default:
			throw new StrategyNotSupportedException(String.format("'%s' strategy not supported", annotation.using()));
		}
	}

	WindowElement createIndependentWindowViewElement(WiniumDriver driver, ApplicationView annotation)
			throws StrategyNotSupportedException {
		WindowElement element = null;
		switch (annotation.how()) {
		case ID: {
			element = new WindowElement(driver, By.id(annotation.using()));
			LOG.info(String.format("Window element instanciated [strategy: id{%s}]", annotation.using()));
			return element;
		}
		case XPATH: {
			element = new WindowElement(driver, By.xpath(annotation.using()));
			LOG.info(String.format("Window element instanciated [strategy: xpath{%s}]", annotation.using()));
			return element;
		}
		case NAME: {
			element = new WindowElement(driver, new CustomDesktopByName(annotation.using()));
			LOG.info(String.format("Window element instanciated [strategy: name{%s}]", annotation.using()));
			return element;
		}
		case CLASS_NAME: {
			element = new WindowElement(driver, By.className(annotation.using()));
			LOG.info(String.format("Window element instanciated [strategy: class-name{%s}]", annotation.using()));
			return element;
		}
		case UNSET:
			throw new StrategyNotPassedException("A strategy must be informed in FindBy annotation");
		default:
			throw new StrategyNotSupportedException(String.format("'%s' strategy not supported", annotation.using()));
		}
	}

	WindowElement createWindowElement(WindowElement applicationView, FindBy annotation)
			throws StrategyNotSupportedException {
		WindowElement element = null;
		switch (annotation.how()) {
		case ID: {
			element = new WindowElement(applicationView, By.id(annotation.using()));
			LOG.info(String.format("Window element instanciated [strategy: id{%s}]", annotation.using()));
			return element;
		}
		case XPATH: {
			element = new WindowElement(applicationView, By.xpath(annotation.using()));
			LOG.info(String.format("Window element instanciated [strategy: xpath{%s}]", annotation.using()));
			return element;
		}
		case NAME: {
			element = new WindowElement(applicationView, By.name(annotation.using()));
			LOG.info(String.format("Window element instanciated [strategy: name{%s}]", annotation.using()));
			return element;
		}
		case CLASS_NAME: {
			element = new WindowElement(applicationView, By.className(annotation.using()));
			LOG.info(String.format("Window element instanciated [strategy: class-name{%s}]", annotation.using()));
			return element;
		}
		case UNSET:
			throw new StrategyNotPassedException("A strategy must be informed in FindBy annotation");
		default:
			throw new StrategyNotSupportedException(String.format("'%s' strategy not supported", annotation.using()));
		}
	}
	
	public WindowElement getApplicationView() {
		return this.applicationView;
	}	
}
