package com.thegingerbeardd.dndbot.processor.impl;

import com.thegingerbeardd.dndbot.character.utils.fifthedition.AbilityTypes;
import com.thegingerbeardd.dndbot.generator.SavingThrowResponseGenerator;
import com.thegingerbeardd.dndbot.party.Party;
import com.thegingerbeardd.dndbot.processor.ChatProcessor;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Arrays;

public class FifthEditionChatProcessor implements ChatProcessor {

    private static final Logger LOGGER = LogManager.getLogger(FifthEditionChatProcessor.class);
    private Party party;

    public void setParty(Party party) {
        this.party = party;
    }

    public String dealWithSavingThrowCommand(String[] inputs) {
        if (inputs.length < 3)
            throw new ArrayIndexOutOfBoundsException();
        else if (inputs[2] == null || !party.containsPartyMember(inputs[2]))
            return "I'm sorry, but that party member doesn't exist!";
        else {
            AbilityTypes type = AbilityTypes.valueOf(inputs[3].toUpperCase().substring(0, 3));
            return SavingThrowResponseGenerator.generateSavingThrowResult(party.getPartyMemberWithName(inputs[2]), type);
        }
    }

    @Override
    public String processInputMessage(String msg) {
        String[] inputs = msg.split(" ", -1);
        LOGGER.debug("Received message with tokens: " + Arrays.toString(inputs));
        try {
            switch (inputs[1].toLowerCase()) {
                case "whois":
                case "who":
                    return "The current party is made up of:" + party.toString();
                case "save":
                    return dealWithSavingThrowCommand(inputs);
                default:
                    return "I don't understand that message!!\n" + inputs[1] + " is not a command I recognize.";
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return "That command doesn't seem to have enough arguments!";
        }
    }

}
