package io.openbdt.element.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.openqa.selenium.support.FindBy;

import io.openbdt.types.AndroidVersion;
import io.openbdt.types.IOSVersion;

/**
 * 
 * @author splait
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface MayNotExist {

	/**
	 * Android versions that the element may not appear on the screen
	 * @return
	 */
	public AndroidVersion[] androidVersion() default AndroidVersion.NONE;
	
	public IOSVersion[] iosVersion() default IOSVersion.NONE;
	
	public FindBy alternateMethod();
}