package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
    private static final String PROPERTIES_FILE_PATH = "src/test/resources/properties/clipbook.properties";
    private static final String SELECTORS_PROPERTIES = "src/test/resources/properties/selectors.properties";
    private static final String EXTENT_CONFIG = "src/test/resources/configuration/extent-config.xml";

    public static String getProperty(String propertyName) {
        Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(PROPERTIES_FILE_PATH);
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(propertyName);
    }

    public static String getSelectorProperty(String propertyName) {
        Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(SELECTORS_PROPERTIES);
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(propertyName);
    }
}