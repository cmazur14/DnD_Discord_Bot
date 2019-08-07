package com.thegingerbeardd.dndbot.processor.impl;

import com.thegingerbeardd.dndbot.character.utils.fifthedition.AbilityTypes;
import com.thegingerbeardd.dndbot.generator.SavingThrowResponseGenerator;
import com.thegingerbeardd.dndbot.parsing.FifthEdtionCommandParser;
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

    @Override
    public String processInputMessage(String msg) {
        String[] inputs = msg.split(" ", -1);
        LOGGER.debug("Received message with tokens: " + Arrays.toString(inputs));
        String response;
        try {
            switch (inputs[1].toLowerCase()) {
                case "whois":
                case "who":
                    response = "The current party is made up of:" + party.toString();
                    break;
                default:
                    response = FifthEdtionCommandParser.parseAndGenerateResponse(inputs);
                    if (response != null)
                        response = "I don't understand that message!!\n" + inputs[1] + " is not a command I recognize.";
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            response = "That command doesn't seem to have enough arguments!";
        }
        return response;
    }

}
