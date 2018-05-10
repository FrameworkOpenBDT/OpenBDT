package io.openbdt.types;

/**
 * 
 * @author splait
 *
 */
public enum AndroidVersion implements MobileVersion{	
	
	NONE, DONUT("1.6"), ECLAIR("2.0", "2.1"), FROYO("2.2"), GINGERBREAD("2.3"), HONEYCOMB("3.0", "3.1", "3.2"), ICE_CREAM_SANDWICH("4.0"), JELLY_BEAN("4.1", "4.2", "4.3"), KITKAT("4.4"), LOLLIPOP("5.0", "5.0.2", "5.1", "5.1.1"), MARSHMALLOW("6.0", "6.0.1"), NOUGAT("7.0", "7.1", "7.1.2"), OREO("8.0", "8.1");
	
	private AndroidVersion(String... version){
		this.version = version;
	}
	
	String[] version;
	
	@Override
	public String[] getVersion(){
		return this.version;
	}
}
