package com.thegingerbeardd.dndbot.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFileReader {

    private InputStream appPropertiesInputStream;
    private BufferedReader systemPropertiesInputStream;
    private Properties appProperties;

    public Properties getApplicationProperties() throws IOException {
        if (appProperties != null)
            return appProperties;
        else {
            appProperties = new Properties();
            appPropertiesInputStream = getClass().getClassLoader().getResourceAsStream(TTBotConstants.APPLICATION_PROPERTIES);

            if (appPropertiesInputStream != null)
                appProperties.load(appPropertiesInputStream);
            else
                throw new FileNotFoundException("property file: '" + TTBotConstants.APPLICATION_PROPERTIES + "' could not be found");
            appPropertiesInputStream.close();
            return appProperties;
        }
    }

    public Properties getSystemProperties(Properties p) throws IOException{
        Properties prop = new Properties();
        systemPropertiesInputStream = new BufferedReader(new FileReader(
                p.getProperty(TTBotConstants.CONFIG_FILE_PATH_PROPERTY_NAME) +
                         p.getProperty(TTBotConstants.CONFIG_FILE_PROPERTY_NAME)));

        if (systemPropertiesInputStream != null)
            prop.load(systemPropertiesInputStream);
        else
            throw new FileNotFoundException("Cannot find system configuration file at location: " +
                    p.getProperty(TTBotConstants.CONFIG_FILE_PATH_PROPERTY_NAME) +
                    p.getProperty(TTBotConstants.CONFIG_FILE_PROPERTY_NAME));
        return prop;
    }

    public String getBotToken(Properties p) {
        return p.getProperty("bot.token");
    }

}
