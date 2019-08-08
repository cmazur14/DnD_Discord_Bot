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
    }

    @Test
    public void emptyCommandRespondsWithNotUnderstanding() {
        testParty.addNewPartyMemberWithName("Testname");
        String[] inputs = generateInputsFromCommand("");
        String output = FifthEditionCommandParser.parseAndGenerateResponse(inputs, testParty);
        assertEquals(TTBotConstants.INVALID_COMMAND_MESSAGE, output);
    }

    @Test
    public void invalidCommandRespondsWithNotUnderstanding() {
        testParty.addNewPartyMemberWithName("Testname");
        String[] inputs = generateInputsFromCommand("this is not a valid command");
        String output = FifthEditionCommandParser.parseAndGenerateResponse(inputs, testParty);
        assertEquals(TTBotConstants.INVALID_COMMAND_MESSAGE, output);
    }

    @Test
    public void validCommandWithMissingArgumentsRespondsWithNotUnderstanding() {
        testParty.addNewPartyMemberWithName("Testname");
        String[] inputs = generateInputsFromCommand("add");
        String output = FifthEditionCommandParser.parseAndGenerateResponse(inputs, testParty);
        assertEquals(TTBotConstants.INVALID_ARGUMENTS_MESSAGE, output);
    }

    @Test
    public void whoCommandWorksAsIntended() {
        testParty.addNewPartyMemberWithName("Testname");
        String[] inputs = generateInputsFromCommand("who");
        String output = FifthEditionCommandParser.parseAndGenerateResponse(inputs, testParty);
        assertEquals("The party is made up of: \n\t-Testname, a wimpy little shit who can't do anything and is still level 0", output);
    }

    @Test
    public void whoIsCommandWorksAsIntended() {
        testParty.addNewPartyMemberWithName("Testname");
        String[] inputs = generateInputsFromCommand("whois");
        String output = FifthEditionCommandParser.parseAndGenerateResponse(inputs, testParty);
        assertEquals("The party is made up of: \n\t-Testname, a wimpy little shit who can't do anything and is still level 0", output);
    }

    @Test
    public void whoAndWhoIsCommandIsCaseInsensitive() {
        testParty.addNewPartyMemberWithName("Testname");
        String[] inputs = generateInputsFromCommand("wHoIS");
        String output = FifthEditionCommandParser.parseAndGenerateResponse(inputs, testParty);
        assertEquals("The party is made up of: \n\t" +
                "-Testname, a wimpy little shit who can't do anything and is still level 0", output);
        inputs = generateInputsFromCommand("WHO");
        output = FifthEditionCommandParser.parseAndGenerateResponse(inputs, testParty);
        assertEquals("The party is made up of: \n\t" +
                "-Testname, a wimpy little shit who can't do anything and is still level 0", output);
        inputs = generateInputsFromCommand("WHOIS");
        output = FifthEditionCommandParser.parseAndGenerateResponse(inputs, testParty);
        assertEquals("The party is made up of: \n\t" +
                "-Testname, a wimpy little shit who can't do anything and is still level 0", output);
        inputs = generateInputsFromCommand("wHO");
        output = FifthEditionCommandParser.parseAndGenerateResponse(inputs, testParty);
        assertEquals("The party is made up of: \n\t" +
                "-Testname, a wimpy little shit who can't do anything and is still level 0", output);
        inputs = generateInputsFromCommand("WhO");
        output = FifthEditionCommandParser.parseAndGenerateResponse(inputs, testParty);
        assertEquals("The party is made up of: \n\t" +
                "-Testname, a wimpy little shit who can't do anything and is still level 0", output);
    }

    @Test
    public void addCommandWorksAsIntended() {
        String[] inputs = generateInputsFromCommand("add Name1");
        String output = FifthEditionCommandParser.parseAndGenerateResponse(inputs, testParty);
        assertEquals(output, "Name1 has been added as a character!");
        output = FifthEditionCommandParser.parseAndGenerateResponse(generateInputsFromCommand("who"), testParty);
        assertEquals("The party is made up of: \n\t" +
                "-Name1, a wimpy little shit who can't do anything and is still level 0", output);
        inputs = generateInputsFromCommand("add Name2");
        output = FifthEditionCommandParser.parseAndGenerateResponse(inputs, testParty);
        assertEquals(output, "Name2 has been added as a character!");
        output = FifthEditionCommandParser.parseAndGenerateResponse(generateInputsFromCommand("who"), testParty);
        assertEquals("The party is made up of: \n\t" +
                "-Name2, a wimpy little shit who can't do anything and is still level 0\n\t" +
                "-Name1, a wimpy little shit who can't do anything and is still level 0", output);
    }

}
