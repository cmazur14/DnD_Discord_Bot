package com.thegingerbeardd.dndbot.parsing;

import com.thegingerbeardd.dndbot.party.Party;
import com.thegingerbeardd.dndbot.utils.TTBotConstants;

public class FifthEditionCommandParser {

    public static String parseAndGenerateResponse(String[] inputs, Party party) {
        String response = null;
        switch (inputs[1].toLowerCase()) {
            case "whois":
            case "who":
                response = party.toString();
                break;
            case "add":
                if (inputs.length < 3) {
                    response = TTBotConstants.INVALID_ARGUMENTS_MESSAGE;
                    break;
                }
                party.addNewPartyMemberWithName(inputs[2]);
                response = inputs[2] + " has been added as a character!";
                break;
            default:
                response = parseRollCommandAndGenerateResponse(inputs, party);
        }
        if (response == null)
            response = TTBotConstants.INVALID_COMMAND_MESSAGE;
        return response;
    }

    public static String parseRollCommandAndGenerateResponse(String [] inputs, Party party) {
        return null;
    }
}
