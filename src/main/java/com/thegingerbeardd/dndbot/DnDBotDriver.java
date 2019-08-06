package com.thegingerbeardd.dndbot;

import com.thegingerbeardd.dndbot.character.sheet.CharacterClass;
import com.thegingerbeardd.dndbot.dice.Die;
import com.thegingerbeardd.dndbot.discord.DnDBotListenerAdapter;
import com.thegingerbeardd.dndbot.party.Party;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;
import com.thegingerbeardd.dndbot.character.Character;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.security.auth.login.LoginException;
import java.util.HashMap;

public class DnDBotDriver {

    private static final Logger LOGGER = LogManager.getLogger(DnDBotDriver.class);

    public static void main(String[] args) throws LoginException {
        JDABuilder builder = new JDABuilder(AccountType.BOT);
        builder.setToken("NjA3OTA1ODM5MzI3NjA4ODUz.XUgbAA.1wI_noWOYjI07QmwjNCHxF9ZIso");

        /* Utility Debugging Method*/
        doTestThings();

        LOGGER.debug("Beginning build");
        DnDBotListenerAdapter listener = new DnDBotListenerAdapter();
        listener.addParty(buildDefaultParty());
        builder.addEventListeners(listener);
        builder.build();
        LOGGER.debug("Build complete");
    }

    private static void doTestThings() {
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
        Character mainCharacter = new Character("BoatyMcBoatface");
        mainCharacter.getProperties().setOwner(mainCharacter);
        mainCharacter.getCharacterClasses().add(new CharacterClass());
        mainCharacter.getProperties().getAbilityScores().setStrength(18);
        mainCharacter.getProperties().getAbilityScores().setDexterity(16);
        mainCharacter.getProperties().getAbilityScores().setConstitution(14);
        mainCharacter.getProperties().getAbilityScores().setIntelligence(12);
        mainCharacter.getProperties().getAbilityScores().setWisdom(10);
        mainCharacter.getProperties().getAbilityScores().setCharisma(8);
        mainCharacter.getProperties().isProficientInAthletics = false;
        party.addPartyMember(mainCharacter);
        return party;
    }

}
