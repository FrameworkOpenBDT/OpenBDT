package io.openbdt.filter;

import java.io.File;
import java.io.FileFilter;

/**
 * File filter json 
 * 
 */
public class FileFilterJson implements FileFilter {

	/**
	 * Extension file json
	 */
	public static final String JSON_EXTENSION = ".json";
	
	/**
	 * is file json
	 * 
	 * @param pathname - File
	 * 
	 * @return boolean - TRUE if file is json
	 */
	@Override
	public boolean accept(final File pathname) {
		
		if (pathname != null) {
			if (pathname.getName().endsWith(JSON_EXTENSION)) {
				return true;
			}
		}
		
		return false;
	}
}
