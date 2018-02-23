package utils;

import org.openqa.selenium.remote.BrowserType;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestProperties {

    private static Properties properties;

    private static synchronized Properties getProperties() {
        if (properties == null) {
            properties = new Properties();
            try {
                InputStream propertiesFile = TestProperties.class.getClassLoader().getResourceAsStream("test.properties");
                properties.load(propertiesFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return properties;
    }

    private static String getPropertyByName(String propertyName) {
        return getProperties().getProperty(propertyName);
    }

    public static String getBaseUrl() {
        return getPropertyByName("base_url");
    }

    public static String getBrowserType() {
        return getPropertyByName("driver");
    }
}

