package by.sichnenko.committee.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class ResourceManager {
    private static final Logger LOGGER = LogManager.getLogger(ResourceManager.class);

    public static String readProperty(String key, String filePropertiesName) {
        try {
            ResourceBundle resourceBundle = ResourceBundle.getBundle(filePropertiesName);
            return resourceBundle.getString(key);
        } catch (MissingResourceException e) {
            LOGGER.error("Cannot find configuration file:(",e);
            throw new RuntimeException(e);
        }
    }
}
