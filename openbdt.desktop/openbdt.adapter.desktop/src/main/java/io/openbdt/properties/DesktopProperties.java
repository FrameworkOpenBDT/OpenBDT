package io.openbdt.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class DesktopProperties {

	private Properties properties;
	private static String DESKTOP_PROPERTIES_FILE= "desktop.properties";
	
	/**
	 * LOG
	 */
	private static final Logger LOG = Logger.getLogger(DesktopProperties.class.getName());
	
	public DesktopProperties() throws FileNotFoundException, IOException {
		LOG.info("loading desktop properties");
		this.properties = new Properties();
		this.properties.load(new FileInputStream(new File(this.DESKTOP_PROPERTIES_FILE)));
	}
	
	public String getProperty(String key) {
		return this.properties.getProperty(key);
	}
}
