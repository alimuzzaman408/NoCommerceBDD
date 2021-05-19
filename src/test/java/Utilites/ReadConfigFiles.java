package Utilites;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReadConfigFiles {
	private static final Logger LOGGER = LogManager.getLogger(ReadConfigFiles.class);

    public static String getPropertyValues(String propName) {
        Properties prop;
        String propValue = null;
        try {
            prop = new LoadConfigFiles().readPropertyValues();
            propValue = prop.getProperty(propName);
        } catch (Exception e) {
            LOGGER.error("Exception is: " + e.getMessage());
        }
        return propValue;
    }
}
