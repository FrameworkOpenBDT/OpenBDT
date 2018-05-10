package io.openbdt.steps.business;

import org.springframework.beans.factory.annotation.Autowired;

import io.openbdt.element.MobileScreenElement;
import io.openbdt.mapping.AppObject;

public class  MobileStepBusiness<T extends AppObject> {

	private T appObjectClass; 

	private MobileScreenElement viewElement;
	
//	@Autowired
//	public MobileStepBusiness(T appObjectClass) {
//		this.appObjectClass = appObjectClass;
//		this.viewElement = new MobileScreenElement(this.appObjectClass.getMobileCustomDriver());
//	}
	
	public T getAppObjectClass() {
		return appObjectClass;
	}

	public void setAppObjectClass(T appObjectClass) {
		this.appObjectClass = appObjectClass;
	}
	
	public MobileScreenElement getViewElement() {
		return viewElement;
	}

	public void setViewElement(MobileScreenElement viewElement) {
		this.viewElement = viewElement;
	}
}
