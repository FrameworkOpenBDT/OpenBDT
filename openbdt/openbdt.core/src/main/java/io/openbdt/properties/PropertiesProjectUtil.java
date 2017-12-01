package io.openbdt.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import org.apache.log4j.Logger;

import javax.xml.bind.PropertyException;

import io.openbdt.exception.PropertyNotFoundException;

/**
 * Classe para acessar ler o projeto.properties
 * 
 * @author caio.moraes
 *
 */
public final class PropertiesProjectUtil {

	/**
	 * LOG
	 */
	private static final Logger LOG = Logger.getLogger(PropertiesProjectUtil.class.getName());

	private final String DEFAULT_PROPERTY_FILE = "projeto.properties";

	/**
	 * Instance
	 */
	private static PropertiesProjectUtil instance;

	/**
	 * atributo com arquivo properties carregado.
	 */
	private static Properties propertiesLoaded;

	private PropertiesProjectUtil() {
	};

	/**
	 * Carrega arquivo de propriedades.
	 * 
	 * @param propertyFileName
	 * 
	 * @return Properties
	 * 
	 * @throws
	 */
	private void loadPropertiesFile() throws PropertyNotFoundException {
		LOG.info("Carregando arquivo de propriedades do projeto.properties");

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
	 * 
	 * @return String
	 * 
	 * @throws Exception
	 */
	public static String getProperty(final String propertyName) throws PropertyNotFoundException {
		LOG.info("Obtendo propriedade através getProperty do projeto.properties");

		if (instance == null) {
			instance = new PropertiesProjectUtil();
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
			LOG.fatal(e.getMessage(), e);
			throw new PropertyNotFoundException(e);
		}
	}
}
