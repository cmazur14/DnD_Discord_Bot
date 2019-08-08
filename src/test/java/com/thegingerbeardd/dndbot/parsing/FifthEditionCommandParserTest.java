package com.thegingerbeardd.dndbot.parsing;

import com.thegingerbeardd.dndbot.party.Party;
import com.thegingerbeardd.dndbot.utils.TTBotConstants;
import com.thegingerbeardd.dndbot.utils.TestConstants;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FifthEditionCommandParserTest {

    private Party testParty;

    private String[] generateInputsFromCommand(String input) {
        String output = new StringBuilder()
                .append(TestConstants.BOT_IDENTIFIER)
                .append(" ")
                .append(input)
                .toString();
        return output.split(" ", -1);
    }

    @Before
    public void setUp() {
        testParty = new Party();
        testParty.addNewPartyMemberWithName("Testname");
    }

    @Test
    public void emptyCommandRespondsWithNotUnderstanding() {
        String[] inputs = generateInputsFromCommand("");
        String output = FifthEditionCommandParser.parseAndGenerateResponse(inputs, testParty);
        assertEquals(TTBotConstants.INVALID_COMMAND_MESSAGE, output);
    }

    @Test
    public void invalidCommandRespondsWithNotUnderstanding() {
        String[] inputs = generateInputsFromCommand("this is not a valid command");
        String output = FifthEditionCommandParser.parseAndGenerateResponse(inputs, testParty);
        assertEquals(TTBotConstants.INVALID_COMMAND_MESSAGE, output);
    }

    @Test
    public void validCommandWithMissingArgumentsRespondsWithNotUnderstanding() {
        String[] inputs = generateInputsFromCommand("add");
        String output = FifthEditionCommandParser.parseAndGenerateResponse(inputs, testParty);
        assertEquals(TTBotConstants.INVALID_ARGUMENTS_MESSAGE, output);
    }

    @Test
    public void whoCommandWorksAsIntended() {
        String[] inputs = generateInputsFromCommand("who");
        String output = FifthEditionCommandParser.parseAndGenerateResponse(inputs, testParty);
        assertEquals("The party is made up of: \n\t-Testname, a wimpy little shit who can't do anything and is still level 0", output);
    }

    @Test
    public void whoIsCommandWorksAsIntended() {
        String[] inputs = generateInputsFromCommand("whois");
        String output = FifthEditionCommandParser.parseAndGenerateResponse(inputs, testParty);
        assertEquals("The party is made up of: \n\t-Testname, a wimpy little shit who can't do anything and is still level 0", output);
    }

    @Test
    public void whoAndWhoIsCommandIsCaseInsensitive() {
        String[] inputs = generateInputsFromCommand("wHoIS");
        String output = FifthEditionCommandParser.parseAndGenerateResponse(inputs, testParty);
        assertEquals("The party is made up of: \n\t-Testname, a wimpy little shit who can't do anything and is still level 0", output);
        inputs = generateInputsFromCommand("WHO");
        output = FifthEditionCommandParser.parseAndGenerateResponse(inputs, testParty);
        assertEquals("The party is made up of: \n\t-Testname, a wimpy little shit who can't do anything and is still level 0", output);
        inputs = generateInputsFromCommand("WHOIS");
        output = FifthEditionCommandParser.parseAndGenerateResponse(inputs, testParty);
        assertEquals("The party is made up of: \n\t-Testname, a wimpy little shit who can't do anything and is still level 0", output);
        inputs = generateInputsFromCommand("wHO");
        output = FifthEditionCommandParser.parseAndGenerateResponse(inputs, testParty);
        assertEquals("The party is made up of: \n\t-Testname, a wimpy little shit who can't do anything and is still level 0", output);
        inputs = generateInputsFromCommand("WhO");
        output = FifthEditionCommandParser.parseAndGenerateResponse(inputs, testParty);
        assertEquals("The party is made up of: \n\t-Testname, a wimpy little shit who can't do anything and is still level 0", output);
    }

}
