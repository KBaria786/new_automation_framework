package com.wolters_kluwer.automation_framework.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility class to read properties file.
 */
public class PropertiesReader {
	
	private static final Logger logger = LoggerFactory.getLogger(PropertiesReader.class);
	
	private PropertiesReader() {}

	/**
	 * Get properties using the given 'propertiesFileName'.
	 * @param propertiesFilePath location of the .properties file
	 * @return properties object
	 */
	public static Properties getProperties(String propertiesFileLocation) {
		Properties properties = new Properties();
		try(InputStream inputStream = new FileInputStream(propertiesFileLocation)) {
			properties.load(inputStream);
		} catch (IOException e) {
			logger.error("Exception occurred while loading properties file", e);
		}
		return properties;
	}
	
}