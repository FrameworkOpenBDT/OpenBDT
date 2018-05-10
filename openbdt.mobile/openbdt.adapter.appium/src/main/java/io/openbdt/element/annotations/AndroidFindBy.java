package io.openbdt.element.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.openqa.selenium.support.How;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface AndroidFindBy{

	public How how() default How.UNSET;
	
	public String using();
}
