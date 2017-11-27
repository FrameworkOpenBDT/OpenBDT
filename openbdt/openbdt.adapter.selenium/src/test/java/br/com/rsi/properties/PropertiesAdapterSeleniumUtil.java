package br.com.rsi.properties;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.PropertyException;

import io.openbdt.exception.PropertyNotFoundException;

/**
 * Classe para acessar ler o adapter_selenium.properties
 * 
 * @author guilherme.sousa
 *
 */
public final class PropertiesAdapterSeleniumUtil {

	/**
	 * LOG
	 */
	private static final Logger LOG = Logger.getLogger(PropertiesAdapterSeleniumUtil.class.getName());

	private final String DEFAULT_PROPERTY_FILE = "adapter_selenium.properties";

	/**
	 * Instance
	 */
	private static PropertiesAdapterSeleniumUtil instance;

	/**
	 * atributo com arquivo properties carregado.
	 */
	private static Properties propertiesLoaded;

	private PropertiesAdapterSeleniumUtil() {
	};

	/**
	 * Carrega arquivo de propriedades.
	 * 
	 * @param propertyFileName
	 * 
	 * @throws
	 */
	private void loadPropertiesFile() throws PropertyNotFoundException {
		LOG.info("Carregando arquivo de propriedades do adapter_selenium.properties");

		this.propertiesLoaded = new Properties();

		InputStream inputStream = null;
		try {

			inputStream = PropertiesAdapterSeleniumUtil.class.getResourceAsStream(DEFAULT_PROPERTY_FILE);
			this.propertiesLoaded.load(inputStream);

		} catch (FileNotFoundException e) {
			LOG.log(Level.SEVERE, "", e);
			throw new PropertyNotFoundException(e);
		} catch (IOException ex) {
			LOG.log(Level.SEVERE, "", ex);
			throw new PropertyNotFoundException(ex);
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					LOG.log(Level.SEVERE, "", e);
					throw new PropertyNotFoundException(e);
				}
			}
		}
	}

	/*
	 * Obtem a propriedade no arquivo para a chave informada por argumento.
	 * 
	 * @param propertyName
	 * 
	 * @return String
	 * 
	 * @throws Exception
	 */
	public static String getProperty(final String propertyName) throws PropertyNotFoundException {
		LOG.info("Obtendo propriedade através getProperty do adapter_selenium.properties");

		if (instance == null) {
			instance = new PropertiesAdapterSeleniumUtil();
		}

		try {
			if (propertiesLoaded == null) {
				instance.loadPropertiesFile();
			}

			if (propertyName == null || "".equals(propertyName)) {
				return null;
			}
			return propertiesLoaded.getProperty(propertyName);
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "", e);
			throw new PropertyNotFoundException(e);
		}
	}
}
