package io.openbdt.types;

/**
 * 
 * @author splait
 *
 */
public enum IOSVersion implements MobileVersion{

	NONE, IOS9("9.3.5"), IOS10("10.0", "10.1", "10.2", "10.3"), IOS11("11.0", "11.1", "11.2");
	
	private IOSVersion(String... version){
		this.version = version;
	}
	
	private String[] version;
	
	@Override
	public String[] getVersion(){
		return this.version;
	}
}
