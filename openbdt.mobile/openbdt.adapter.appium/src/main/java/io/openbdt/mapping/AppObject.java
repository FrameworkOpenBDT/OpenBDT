package io.openbdt.mapping;

import java.lang.reflect.Field;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import io.appium.java_client.AppiumDriver;
import io.openbdt.driver.MobileCustomDriver;
import io.openbdt.driver.MobileDriverSupport;
import io.openbdt.element.MobileElement;
import io.openbdt.element.annotations.AndroidFindBy;
import io.openbdt.element.annotations.IOSFindBy;
import io.openbdt.element.annotations.MayNotExist;
import io.openbdt.exception.StrategyNotPassedException;
import io.openbdt.exception.StrategyNotSupportedException;
import io.openbdt.exception.VersionNotSupportedException;
import io.openbdt.types.AndroidVersion;
import io.openbdt.types.IOSVersion;
import io.openbdt.types.MobileVersion;

/**
 * Mobile page object class
 * 
 * @author splait
 *
 */
@ContextConfiguration("/context.xml")
public class AppObject {

	private MobileDriverSupport mobileDriverSupport;
	
	@Autowired
	private MobileCustomDriver mobileCustomDriver;
	private String udid;
	private static Logger LOG = Logger.getLogger(AppObject.class);

//	/**
//	 * Default Constructor
//	 */
//	public AppObject() {}
//	
//	/**
//	 * 
//	 * @param udid
//	 *            Device unique identifier
//	 * @param mobileDriverSupport
//	 *            Object that provides driver connection per device udid, actually
//	 *            injected by spring
//	 * @throws IllegalArgumentException
//	 * @throws IllegalAccessException
//	 * @throws StrategyNotSupportedException
//	 * @throws DriverNotExistException
//	 */
//	public AppObject(String udid, MobileDriverSupport mobileDriverSupport) throws IllegalArgumentException,
//			IllegalAccessException, StrategyNotSupportedException, DriverNotExistException {
//		LOG.debug("#################################################");
//		LOG.debug("APP OBJECT CLASS CRIADA:\nUDID: " + udid + "\nmobileDriverSupport: " + mobileDriverSupport
//				+ "\nINSTANCE: " + this);
//		LOG.debug("#################################################");
//		this.udid = udid;
//		this.mobileDriverSupport = mobileDriverSupport;
//		PageFactory.initElements(
//				(AppiumDriver<io.appium.java_client.MobileElement>) getMobileDriverSupport().getDriver(udid), this);
//		LOG.debug(String.format("Page initialized to '%s'", udid));
//	}

/*	@PostConstruct
	public void init() throws IllegalArgumentException, IllegalAccessException, StrategyNotSupportedException {
		this.udid = (String) this.mobileCustomDriver.getUdid();
		PageFactory.initElements((AppiumDriver<io.appium.java_client.MobileElement>) this.mobileCustomDriver.getAppiumDriver(), this);
		LOG.debug(String.format("Page initialized to '%s'", udid));
	}*/
	
	@PostConstruct
	public void init() throws IllegalArgumentException, IllegalAccessException, StrategyNotSupportedException {
		this.udid = this.mobileCustomDriver.getUdid();
		PageFactory.initElements(this.mobileCustomDriver, this);
		LOG.debug(String.format("Page initialized to '%s'", udid));
	}
	
	public String getUdid() {
		return this.udid;
	}

	public MobileDriverSupport getMobileDriverSupport() {
		return this.mobileDriverSupport;
	}
	
	public MobileCustomDriver getMobileCustomDriver() {
		return mobileCustomDriver;
	}

	public void setMobileDriverSupport(MobileDriverSupport mobileDriverSupport) {
		this.mobileDriverSupport = mobileDriverSupport;
	}

	public void setUdid(String udid) {
		this.udid = udid;
	}

	private static class PageFactory {

//		@Deprecated
//		static void initElements(AppiumDriver<? extends io.appium.java_client.MobileElement> driver, AppObject clazz)
//				throws IllegalArgumentException, IllegalAccessException, StrategyNotSupportedException {
//			Field[] fields = clazz.getClass().getDeclaredFields();
//			LOG.debug("###########################################");
//			LOG.debug("DRIVER CLASS: " + driver.getClass().getName());
//			LOG.debug("###########################################");
//			if (driver.getClass() == IOSDriver.class) {
//				for (int i = 0; i < fields.length; i++) {
//					if (fields[i].isAnnotationPresent(IOSFindBy.class)) {
//						if (isThereAnAlternativeSearchMethodForTheElement(driver, fields[i]) != null) {
//							FindBy annotation = null;
//							annotation = fields[i].getAnnotation(MayNotExist.class).alternateMethod();
//							fields[i].set(clazz, createMobileElement(driver, annotation));
//							LOG.debug(String.format("Instance set to %s.%s", clazz.getClass().getName(),
//									fields[i].getName()));
//						} else {
//							IOSFindBy annotation = null;
//							annotation = fields[i].getAnnotation(IOSFindBy.class);
//							fields[i].set(clazz, createIOSMobileElement(driver, annotation));
//							LOG.debug(String.format("Instance set to %s.%s", clazz.getClass().getName(),
//									fields[i].getName()));
//						}
//					}
//				}
//			} else if (driver.getClass() == AndroidDriver.class) {
//				for (int i = 0; i < fields.length; i++) {
//					if (fields[i].isAnnotationPresent(AndroidFindBy.class)) {
//						if (isThereAnAlternativeSearchMethodForTheElement(driver, fields[i]) != null) {
//							FindBy annotation = fields[i].getAnnotation(MayNotExist.class).alternateMethod();
//							fields[i].set(clazz, createMobileElement(driver, annotation));
//							LOG.debug(String.format("Instance set to %s.%s", clazz.getClass().getName(),
//									fields[i].getName()));
//						} else {
//							AndroidFindBy annotation = fields[i].getAnnotation(AndroidFindBy.class);
//							fields[i].set(clazz, createAndroidMobileElement(driver, annotation));
//							LOG.debug(String.format("Instance set to %s.%s", clazz.getClass().getName(),
//									fields[i].getName()));
//						}
//					}
//				}
//			}
//		}
		
		static void initElements(MobileCustomDriver driverSource, AppObject clazz)
				throws IllegalArgumentException, IllegalAccessException, StrategyNotSupportedException {
			Field[] fields = clazz.getClass().getDeclaredFields();
			LOG.debug("###########################################");
			LOG.debug("Platform: " + driverSource.getPlatformName());
			LOG.debug("###########################################");
			if ("ios".equalsIgnoreCase(driverSource.getPlatformName())) {
				for (int i = 0; i < fields.length; i++) {
					if (fields[i].isAnnotationPresent(IOSFindBy.class)) {
						if (isThereAnAlternativeSearchMethodForTheElement(driverSource, fields[i]) != null) {
							FindBy annotation = null;
							annotation = fields[i].getAnnotation(MayNotExist.class).alternateMethod();
							fields[i].set(clazz, createMobileElement(driverSource, annotation));
							LOG.debug(String.format("Instance set to %s.%s", clazz.getClass().getName(),
									fields[i].getName()));
						} else {
							IOSFindBy annotation = null;
							annotation = fields[i].getAnnotation(IOSFindBy.class);
							fields[i].set(clazz, createIOSMobileElement(driverSource, annotation));
							LOG.debug(String.format("Instance set to %s.%s", clazz.getClass().getName(),
									fields[i].getName()));
						}
					}
				}
			} else if ("android".equalsIgnoreCase(driverSource.getPlatformName())) {
				for (int i = 0; i < fields.length; i++) {
					if (fields[i].isAnnotationPresent(AndroidFindBy.class)) {
						if (isThereAnAlternativeSearchMethodForTheElement(driverSource, fields[i]) != null) {
							FindBy annotation = fields[i].getAnnotation(MayNotExist.class).alternateMethod();
							fields[i].set(clazz, createMobileElement(driverSource, annotation));
							LOG.debug(String.format("Instance set to %s.%s", clazz.getClass().getName(),
									fields[i].getName()));
						} else {
							AndroidFindBy annotation = fields[i].getAnnotation(AndroidFindBy.class);
							fields[i].set(clazz, createAndroidMobileElement(driverSource, annotation));
							LOG.debug(String.format("Instance set to %s.%s", clazz.getClass().getName(),
									fields[i].getName()));
						}
					}
				}
			}
		}

		@Deprecated
		static MobileVersion getVersion(AppiumDriver<? extends io.appium.java_client.MobileElement> driver) {
			DesiredCapabilities capabilities = (DesiredCapabilities) driver.getCapabilities();
			if (capabilities.getCapability("platformName").toString().equalsIgnoreCase("android")) {
				for (AndroidVersion androdVersion : AndroidVersion.values())
					for (String version : androdVersion.getVersion()) {
						if (version.contains(String.valueOf(capabilities.getCapability("platformVersion"))))
							return androdVersion;
					}
			} else if (capabilities.getCapability("platformName").toString().equalsIgnoreCase("ios")) {
				for (IOSVersion iosVersion : IOSVersion.values())
					for (String version : iosVersion.getVersion()) {
						if (version.contains(String.valueOf(capabilities.getCapability("platformVersion"))))
							return iosVersion;
					}
			}
			throw new VersionNotSupportedException(String.format("Not supported [platformName: '%s' version: '%s']",
					capabilities.getPlatform(), capabilities.getVersion()));
		}
		
		static MobileVersion getVersion(MobileCustomDriver driverSource) {
			String platformName = driverSource.getPlatformName();
			String platformVersion = driverSource.getPlatformVersion();
			if (platformName.equalsIgnoreCase("android")) {
				for (AndroidVersion androdVersion : AndroidVersion.values())
					for (String version : androdVersion.getVersion()) {
						if (version.contains(platformVersion))
							return androdVersion;
					}
			} else if(platformName.equalsIgnoreCase("ios")) {
				for (IOSVersion iosVersion : IOSVersion.values())
					for (String version : iosVersion.getVersion()) {
						if (version.contains(platformVersion))
							return iosVersion;
					}
			}
			throw new VersionNotSupportedException(String.format("Not supported [platformName: '%s' version: '%s']",
					platformName, platformVersion));
		}

		@Deprecated
		static FindBy isThereAnAlternativeSearchMethodForTheElement(
				AppiumDriver<? extends io.appium.java_client.MobileElement> driver, Field field) {
			MayNotExist annotation = field.getAnnotation(MayNotExist.class);
			if (annotation != null) {
				MobileVersion mobileVersion = getVersion(driver);
				if (mobileVersion instanceof AndroidVersion) {
					for (int i = 0; i < annotation.androidVersion().length; i++)
						if (annotation.androidVersion()[i] == mobileVersion) {
							LOG.debug(String.format("Android Version [%s: setting alternate search method]",
									annotation.androidVersion()[i]));
							return annotation.alternateMethod();
						}
				} else {
					for (int i = 0; i < annotation.iosVersion().length; i++)
						if (annotation.iosVersion()[i] == mobileVersion) {
							LOG.debug(String.format("IOS Version [%s: setting alternate search method]",
									annotation.iosVersion()[i]));
							return annotation.alternateMethod();
						}
				}
			}
			return null;
		}
		
		static FindBy isThereAnAlternativeSearchMethodForTheElement(
				MobileCustomDriver driverSource, Field field) {
			MayNotExist annotation = field.getAnnotation(MayNotExist.class);
			if (annotation != null) {
				MobileVersion mobileVersion = getVersion(driverSource);
				if (mobileVersion instanceof AndroidVersion) {
					for (int i = 0; i < annotation.androidVersion().length; i++)
						if (annotation.androidVersion()[i] == mobileVersion) {
							LOG.debug(String.format("Android Version [%s: setting alternate search method]",
									annotation.androidVersion()[i]));
							return annotation.alternateMethod();
						}
				} else {
					for (int i = 0; i < annotation.iosVersion().length; i++)
						if (annotation.iosVersion()[i] == mobileVersion) {
							LOG.debug(String.format("IOS Version [%s: setting alternate search method]",
									annotation.iosVersion()[i]));
							return annotation.alternateMethod();
						}
				}
			}
			return null;
		}

//		@Deprecated
//		static MobileElement createAndroidMobileElement(
//				AppiumDriver<? extends io.appium.java_client.MobileElement> driver, AndroidFindBy annotation)
//				throws StrategyNotSupportedException {
//			MobileElement element = null;
//			switch (annotation.how()) {
//			case ID: {
//				element = new MobileElement(driver, By.id(annotation.using()));
//				LOG.debug(String.format("Mobile element instanciated [strategy: id{%s}", annotation.using()));
//				return element;
//			}
//			case XPATH: {
//				element = new MobileElement(driver, By.xpath(annotation.using()));
//				LOG.debug(String.format("Mobile element instanciated [strategy: xpath{%s}", annotation.using()));
//				return element;
//			}
//			case UNSET:
//				throw new StrategyNotPassedException("A strategy must be informed in FindBy annotation");
//			default:
//				throw new StrategyNotSupportedException(
//						String.format("'%s' strategy not supported", annotation.using()));
//			}
//		}
		
		static MobileElement createAndroidMobileElement(
				MobileCustomDriver driver, AndroidFindBy annotation)
				throws StrategyNotSupportedException {
			MobileElement element = null;
			switch (annotation.how()) {
			case ID: {
				element = new MobileElement(driver, By.id(annotation.using()));
				LOG.debug(String.format("Mobile element instanciated [strategy: id{%s}", annotation.using()));
				return element;
			}
			case XPATH: {
				element = new MobileElement(driver, By.xpath(annotation.using()));
				LOG.debug(String.format("Mobile element instanciated [strategy: xpath{%s}", annotation.using()));
				return element;
			}
			case UNSET:
				throw new StrategyNotPassedException("A strategy must be informed in FindBy annotation");
			default:
				throw new StrategyNotSupportedException(
						String.format("'%s' strategy not supported", annotation.using()));
			}
		}

//		@Deprecated
//		static MobileElement createIOSMobileElement(AppiumDriver<? extends io.appium.java_client.MobileElement> driver,
//				IOSFindBy annotation) throws StrategyNotSupportedException {
//			MobileElement element = null;
//			switch (annotation.how()) {
//			case ID: {
//				element = new MobileElement(driver, By.id(annotation.using()));
//				LOG.debug(String.format("Mobile element instanciated [strategy: id{%s}", annotation.using()));
//				return element;
//			}
//			case XPATH: {
//				element = new MobileElement(driver, By.xpath(annotation.using()));
//				LOG.debug(String.format("Mobile element instanciated [strategy: xpath{%s}", annotation.using()));
//				return element;
//			}
//			case UNSET:
//				throw new StrategyNotPassedException("A strategy must be informed in FindBy annotation");
//			default:
//				throw new StrategyNotSupportedException(
//						String.format("'%s' strategy not supported", annotation.using()));
//			}
//		}
		
		static MobileElement createIOSMobileElement(MobileCustomDriver driver,
				IOSFindBy annotation) throws StrategyNotSupportedException {
			MobileElement element = null;
			switch (annotation.how()) {
			case ID: {
				element = new MobileElement(driver, By.id(annotation.using()));
				LOG.debug(String.format("Mobile element instanciated [strategy: id{%s}", annotation.using()));
				return element;
			}
			case XPATH: {
				element = new MobileElement(driver, By.xpath(annotation.using()));
				LOG.debug(String.format("Mobile element instanciated [strategy: xpath{%s}", annotation.using()));
				return element;
			}
			case UNSET:
				throw new StrategyNotPassedException("A strategy must be informed in FindBy annotation");
			default:
				throw new StrategyNotSupportedException(
						String.format("'%s' strategy not supported", annotation.using()));
			}
		}

//		@Deprecated
//		static MobileElement createMobileElement(AppiumDriver<? extends io.appium.java_client.MobileElement> driver,
//				FindBy annotation) throws StrategyNotSupportedException {
//			MobileElement element = null;
//			switch (annotation.how()) {
//			case ID: {
//				element = new MobileElement(driver, By.id(annotation.using()));
//				LOG.debug(String.format("Mobile element instanciated [strategy: id{%s}", annotation.using()));
//				return element;
//			}
//			case XPATH: {
//				element = new MobileElement(driver, By.xpath(annotation.using()));
//				LOG.debug(String.format("Mobile element instanciated [strategy: xpath{%s}", annotation.using()));
//				return element;
//			}
//			case UNSET:
//				throw new StrategyNotPassedException("A strategy must be informed in FindBy annotation");
//			default:
//				throw new StrategyNotSupportedException(
//						String.format("'%s' strategy not supported", annotation.using()));
//			}
//		}
		
		static MobileElement createMobileElement(MobileCustomDriver driverSource,
				FindBy annotation) throws StrategyNotSupportedException {
			MobileElement element = null;
			switch (annotation.how()) {
			case ID: {
				element = new MobileElement(driverSource, By.id(annotation.using()));
				LOG.debug(String.format("Mobile element instanciated [strategy: id{%s}", annotation.using()));
				return element;
			}
			case XPATH: {
				element = new MobileElement(driverSource, By.xpath(annotation.using()));
				LOG.debug(String.format("Mobile element instanciated [strategy: xpath{%s}", annotation.using()));
				return element;
			}
			case UNSET:
				throw new StrategyNotPassedException("A strategy must be informed in FindBy annotation");
			default:
				throw new StrategyNotSupportedException(
						String.format("'%s' strategy not supported", annotation.using()));
			}
		}
	}
}
