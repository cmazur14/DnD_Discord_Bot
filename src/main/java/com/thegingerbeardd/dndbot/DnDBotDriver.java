package com.thegingerbeardd.dndbot;

import com.thegingerbeardd.dndbot.character.classes.ClassList;
import com.thegingerbeardd.dndbot.dice.Die;
import com.thegingerbeardd.dndbot.adapter.DnDBotListenerAdapter;
import com.thegingerbeardd.dndbot.party.Party;
import com.thegingerbeardd.dndbot.processor.ChatProcessor;
import com.thegingerbeardd.dndbot.processor.impl.FifthEditionChatProcessor;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;
import com.thegingerbeardd.dndbot.character.Character;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.security.auth.login.LoginException;
import java.util.HashMap;
import java.util.Scanner;

public class DnDBotDriver {

    private static final Logger LOGGER = LogManager.getLogger(DnDBotDriver.class);
    private boolean startDiscord;

    public static void main(String[] args) throws LoginException {
        /* Utility Debugging Method*/
        ChatProcessor processor = new FifthEditionChatProcessor();
        processor.setParty(buildDefaultParty());
        doTestThings(processor);
        if (startDiscordAfterCommandLineListener(processor))
            startDiscordListenerAdapter(processor);

    }

    private static boolean startDiscordAfterCommandLineListener(ChatProcessor processor) {
        final Scanner kb = new Scanner(System.in);
        System.out.println("Would you like to start the discord server? (Y/N) ");
        String input = kb.next();
        if (input.equalsIgnoreCase("Y"))
            return true;
        else
            new Thread(() -> {
                String nextInput = kb.nextLine();
                while (!nextInput.equals("quit")) {
                    if (nextInput.startsWith("dnd"));
                        System.out.println(processor.processInputMessage(nextInput));
                    nextInput = kb.nextLine();
                }
            }).start();
        return false;
    }

    private static void startDiscordListenerAdapter(ChatProcessor processor) throws LoginException {
        JDABuilder builder = new JDABuilder(AccountType.BOT);
        builder.setToken("NjA3OTA1ODM5MzI3NjA4ODUz.XUgbAA.1wI_noWOYjI07QmwjNCHxF9ZIso");
        LOGGER.debug("Beginning Discord build");
        DnDBotListenerAdapter listener = new DnDBotListenerAdapter();
        builder.addEventListeners(listener);
        builder.build();
        LOGGER.debug("Build complete");
    }

    private static void doTestThings(ChatProcessor processor) {
        Party party = buildDefaultParty();

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
