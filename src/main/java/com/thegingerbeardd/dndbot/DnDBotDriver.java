package com.thegingerbeardd.dndbot;

import com.thegingerbeardd.dndbot.character.classes.ClassList;
import com.thegingerbeardd.dndbot.dice.Die;
import com.thegingerbeardd.dndbot.adapter.DnDBotListenerAdapter;
import com.thegingerbeardd.dndbot.party.Party;
import com.thegingerbeardd.dndbot.processor.ChatProcessor;
import com.thegingerbeardd.dndbot.processor.impl.FifthEditionChatProcessor;
import com.thegingerbeardd.dndbot.utils.PartyPersistanceDAO;
import com.thegingerbeardd.dndbot.utils.PropertiesFileReader;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;
import com.thegingerbeardd.dndbot.character.Character;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class DnDBotDriver {

    private static final Logger LOGGER = LogManager.getLogger(DnDBotDriver.class);
    private boolean startDiscord;
    private static PropertiesFileReader reader;

    public static void main(String[] args) throws LoginException {
        /* Utility Debugging Method*/
        ChatProcessor processor = new FifthEditionChatProcessor();
        processor.setParty(buildDefaultParty());
        reader = new PropertiesFileReader();
        doTestThings(processor);
        /*if (startDiscordAfterCommandLineListener(processor))
            startDiscordListenerAdapter(processor);*/

    }

    private static boolean startDiscordAfterCommandLineListener(ChatProcessor processor) {
        final Scanner kb = new Scanner(System.in);
        //System.out.println("Would you like to start the discord server? (Y/N) ");
        //String input = kb.next();
        String input = "N";
        if (input.equalsIgnoreCase("Y"))
            return true;
        else
            new Thread(() -> {
                String nextInput = kb.nextLine();
                while (!nextInput.equalsIgnoreCase("quit") && !nextInput.equalsIgnoreCase("exit")) {
                    if (nextInput.startsWith("#ttbot") && nextInput != "\n")
                        System.out.println(processor.processInputMessage(nextInput));
                    nextInput = kb.nextLine();
                }
            }).start();
        return false;
    }

    private static void startDiscordListenerAdapter(ChatProcessor processor) throws LoginException {
        JDABuilder builder = new JDABuilder(AccountType.BOT);
        String token = "";
        try {
            token = reader.getBotToken(reader.getSystemProperties(reader.getApplicationProperties()));
        } catch (IOException e) {
            LOGGER.error("Could not get bot token, bot failed to start:\n" + e.getMessage());
            System.exit(-1);
        }
        builder.setToken(token);
        LOGGER.debug("Beginning Discord with token: " + token);
        DnDBotListenerAdapter listener = new DnDBotListenerAdapter();
        listener.setMessageProcessor((FifthEditionChatProcessor) processor);
        builder.addEventListeners(listener);
        builder.build();
        LOGGER.debug("Build complete");
    }

    private static void doTestThings(ChatProcessor processor) {
        PartyPersistanceDAO dao = new PartyPersistanceDAO();
        Party party = (Party) dao.readObjectFromTTBotSaveFile("DEFAULT_PARTY");
        if (party == null)
            LOGGER.warn("Something went wrong with reading the party from the file");
        else
            LOGGER.debug(party);
        /*if (dao.saveObjectToTTBotSaveFile(party, "DEFAULT_PARTY"))
            LOGGER.debug("Successfully saved party: " + party.toString() + "\nto a file");
        else
            LOGGER.warn("Failed to save party");*/
    }

    private void testDiceRandomness() {
        Die d20 = new Die(20);
        HashMap<Integer, Integer> frequencies = new HashMap<Integer, Integer>();
        for (int i = 1; i <= 20; i++)
            frequencies.put(i, 0);
        int currRoll;
        for (int i = 100000; i > 0; i--) {
            currRoll = d20.roll();
            frequencies.put(currRoll, frequencies.get(currRoll) + 1);
        }
        for (int i = 1; i <= 20; i++) {
            String starVal = new String(new char[frequencies.get(i) / 50]).replace('\0', '*');
            System.out.println("Number of " + i + " rolled: \t" + starVal);
        }
    }

    private static Party buildDefaultParty() {
        Party party = new Party();
        party.addPartyMember(Character.generateRandomCharacterWithName("Bob"));
        party.addPartyMember(Character.generateRandomCharacterWithName("Phil"));
        party.addPartyMember(Character.generateRandomCharacterWithName("Joe"));
        party.getPartyMemberWithName("Bob").addClassLevel(ClassList.BARBARIAN);
        return party;
    }

}
