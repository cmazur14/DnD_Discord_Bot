package com.thegingerbeardd.dndbot.processor.impl;

import com.thegingerbeardd.dndbot.parsing.FifthEditionCommandParser;
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
        String response = FifthEditionCommandParser.parseAndGenerateResponse(inputs, party);
        return response;
    }

}
