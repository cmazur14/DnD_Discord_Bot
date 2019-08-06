package com.thegingerbeardd.dndbot;

import com.thegingerbeardd.dndbot.discord.DnDBotListenerAdapter;
import com.thegingerbeardd.dndbot.party.Party;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;
import com.thegingerbeardd.dndbot.character.Character;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.security.auth.login.LoginException;

public class DnDBotDriver {

    private static final Logger LOGGER = LogManager.getLogger(DnDBotDriver.class);

    public static void main(String[] args) throws LoginException {
        JDABuilder builder = new JDABuilder(AccountType.BOT);
        builder.setToken("NjA3OTA1ODM5MzI3NjA4ODUz.XUgbAA.1wI_noWOYjI07QmwjNCHxF9ZIso");
        LOGGER.debug("Beginning build");
        DnDBotListenerAdapter listener = new DnDBotListenerAdapter();
        listener.addParty(buildDefaultParty());
        builder.addEventListeners(listener);
        builder.build();
        LOGGER.debug("Build complete");
    }

    private static Party buildDefaultParty() {
        Party party = new Party();
        Character mainCharacter = new Character("BoatyMcBoatface");
        mainCharacter.getProperties();
        return party;
    }

}
