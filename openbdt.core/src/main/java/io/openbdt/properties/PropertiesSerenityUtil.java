package io.openbdt.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.xml.bind.PropertyException;

import org.apache.log4j.Logger;

import io.openbdt.exception.PropertyNotFoundException;

/**
 * Classe para acessar ler o thucydides.properties
 * @author caio.moraes
 *
 */
public final class PropertiesSerenityUtil {
	
	/**
	 * LOG
	 */
	private static final Logger LOG = Logger.getLogger(PropertiesSerenityUtil.class.getName());

	private static final String DEFAULT_PROPERTY_FILE = "thucydides.properties";

	/**
	 * Instance
	 */
	private static PropertiesSerenityUtil instance;
	
	/**
	 * atributo com arquivo properties carregado.
	 */
	private static Properties propertiesLoaded;

	private PropertiesSerenityUtil() {};
	
	
	/**
	 * Carrega arquivo de propriedades.
	 * 
	 * @param propertyFileName
	 * 
	 * @throws 
	 */
	private void loadPropertiesFile() throws PropertyNotFoundException {
		LOG.info("Carregando arquivo de propriedades do thucydides.properties"); 
		
		this.propertiesLoaded = new Properties();
		FileInputStream fileInputStream = null;
		try {

			fileInputStream = new FileInputStream(DEFAULT_PROPERTY_FILE);
			this.propertiesLoaded.load(fileInputStream);
		} catch (FileNotFoundException e) {
			LOG.fatal(e.getMessage(), e);
			throw new PropertyNotFoundException(e);
		} catch (IOException ex) {
			LOG.fatal(ex.getMessage(), ex);
			throw new PropertyNotFoundException(ex);
		} finally {
			if (fileInputStream != null) {
				try {
					fileInputStream.close();
				} catch (IOException e) {
					LOG.fatal(e.getMessage(), e);
					throw new PropertyNotFoundException(e);
				}
			}
		}
	}
	
	/*
	 * Obtem a propriedade no arquivo para a chave informada por argumento.
	 * 
	 * @param propertyName
	 * @return String
	 * 
	 * @throws Exception 
	 */
	public static String getProperty(final String propertyName) throws PropertyException {
		LOG.info("Obtendo propriedade através getProperty do thucydides.properties");
		
		if (instance == null) {
			instance = new PropertiesSerenityUtil();
		}
		
		try {
			if (propertiesLoaded == null) {
				instance.loadPropertiesFile();
			}
			
			if(propertyName == null || "".equals(propertyName)){
				return null;
			}
			return propertiesLoaded.getProperty(propertyName);
		} catch (Exception e) {
			LOG.fatal(e.getMessage(), e);
			throw new PropertyException(e);
		}
	}
}
