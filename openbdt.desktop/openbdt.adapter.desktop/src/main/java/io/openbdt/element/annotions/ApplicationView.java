package io.openbdt.element.annotions;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.openqa.selenium.support.How;

/**
 * Must be annotated on a Window Element that represents the application window
 * 
 * @author splait
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface ApplicationView {

	public How how() default How.UNSET;
	public String using();
}
