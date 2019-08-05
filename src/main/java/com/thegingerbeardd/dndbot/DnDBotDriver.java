package com.thegingerbeardd.dndbot;

import com.thegingerbeardd.dndbot.discord.DnDBotListenerAdapter;
import com.thegingerbeardd.dndbot.party.Party;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;
import com.thegingerbeardd.dndbot.character.Character;

import javax.security.auth.login.LoginException;

public class DnDBotDriver {

    public static void main(String[] args) throws LoginException {
        JDABuilder builder = new JDABuilder(AccountType.BOT);
        builder.setToken("NjA3OTA1ODM5MzI3NjA4ODUz.XUgbAA.1wI_noWOYjI07QmwjNCHxF9ZIso");
        System.out.println("Beginning build");
        DnDBotListenerAdapter listener = new DnDBotListenerAdapter();
        listener.addParty(buildDefaultParty());
        builder.addEventListeners(listener);
        builder.build();
        System.out.println("Build complete");
    }

    private static Party buildDefaultParty() {
        Party party = new Party();
        Character mainCharacter = new Character("BoatyMcBoatface");
        mainCharacter.getProperties();
        return party;
    }

}
