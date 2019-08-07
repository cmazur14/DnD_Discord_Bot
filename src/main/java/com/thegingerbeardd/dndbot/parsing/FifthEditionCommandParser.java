package com.thegingerbeardd.dndbot.parsing;

import com.thegingerbeardd.dndbot.party.Party;

public class FifthEditionCommandParser {

    public static String parseAndGenerateResponse(String[] inputs, Party party) {
        String response = null;
        switch (inputs[1].toLowerCase()) {
            case "whois":
            case "who":
                response = party.toString();
                break;
            case "add":
                party.addNewPartyMemberWithName(inputs[2]);
                response = inputs[2] + " has been added as a character!";
                break;
            default:
                response = parseRollCommandAndGenerateResponse(inputs, party);
        }
        if (response == null)
            response = "I'm sorry, but I didn't understand that message!";
        return response;
    }

    public static String parseRollCommandAndGenerateResponse(String [] inputs, Party party) {
        return null;
    }
}
