package com.thegingerbeardd.dndbot.utils;

import com.thegingerbeardd.dndbot.party.Party;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PartyPersistanceDAO {

    private ObjectOutputStream toFileStream;
    private ObjectInputStream fromFileStream;
    private static final PropertiesFileReader reader = new PropertiesFileReader();
    private static final Logger LOGGER = LogManager.getLogger(PartyPersistanceDAO.class);
    private static PartyPersistanceDAO instance;

    public static PartyPersistanceDAO getInstance() {
        if (instance == null)
            instance = new PartyPersistanceDAO();
        return instance;
    }

    public boolean saveObjectToTTBotSaveFile(Object obj, String prepender) {
        try {
            toFileStream = new ObjectOutputStream(new FileOutputStream(
                    reader.getApplicationProperties().getProperty(TTBotConstants.SAVE_FILE_PATH_PROPERTY_NAME) +
                            prepender +
                            reader.getApplicationProperties().getProperty(TTBotConstants.SAVE_FILE_PROPERTY_NAME)
            ));
            toFileStream.writeObject(obj);
            toFileStream.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Object readObjectFromTTBotSaveFile(String prepender) {
        try {
            fromFileStream = new ObjectInputStream(new FileInputStream(
                    reader.getApplicationProperties().getProperty(TTBotConstants.SAVE_FILE_PATH_PROPERTY_NAME) +
                            prepender +
                            reader.getApplicationProperties().getProperty(TTBotConstants.SAVE_FILE_PROPERTY_NAME)
            ));
            return fromFileStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

}
