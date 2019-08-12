package com.thegingerbeardd.dndbot.character.utils.fifthedition;

import com.thegingerbeardd.dndbot.character.utils.fifthedition.AbilityTypes;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

public class AbilityTypesTest {

    @Test
    public void getTypeWorksForAllSixTypes() {
        //TODO remove necessity for tests by removing the held value in the constructor and requisite getter
        fail();
    }

    @Test
    public void canParseEnumTypeFromAnyValidInput() {
        assertEquals(AbilityTypes.STR, AbilityTypes.valueOf("str".substring(0, 3).toUpperCase()));
        assertEquals(AbilityTypes.STR, AbilityTypes.valueOf("STRENGTH".substring(0, 3).toUpperCase()));
        assertEquals(AbilityTypes.STR, AbilityTypes.valueOf("Strength".substring(0, 3).toUpperCase()));

        assertEquals(AbilityTypes.DEX, AbilityTypes.valueOf("dex".substring(0, 3).toUpperCase()));
        assertEquals(AbilityTypes.DEX, AbilityTypes.valueOf("DEXTERITY".substring(0, 3).toUpperCase()));
        assertEquals(AbilityTypes.DEX, AbilityTypes.valueOf("Dexterity".substring(0, 3).toUpperCase()));

        assertEquals(AbilityTypes.CON, AbilityTypes.valueOf("con".substring(0, 3).toUpperCase()));
        assertEquals(AbilityTypes.CON, AbilityTypes.valueOf("CONSTITUTION".substring(0, 3).toUpperCase()));
        assertEquals(AbilityTypes.CON, AbilityTypes.valueOf("Constitution".substring(0, 3).toUpperCase()));

        assertEquals(AbilityTypes.INT, AbilityTypes.valueOf("int".substring(0, 3).toUpperCase()));
        assertEquals(AbilityTypes.INT, AbilityTypes.valueOf("INTELLIGENCE".substring(0, 3).toUpperCase()));
        assertEquals(AbilityTypes.INT, AbilityTypes.valueOf("Intelligence".substring(0, 3).toUpperCase()));

        assertEquals(AbilityTypes.WIS, AbilityTypes.valueOf("wis".substring(0, 3).toUpperCase()));
        assertEquals(AbilityTypes.WIS, AbilityTypes.valueOf("WISDOM".substring(0, 3).toUpperCase()));
        assertEquals(AbilityTypes.WIS, AbilityTypes.valueOf("Wisdom".substring(0, 3).toUpperCase()));

        assertEquals(AbilityTypes.CHA, AbilityTypes.valueOf("cha".substring(0, 3).toUpperCase()));
        assertEquals(AbilityTypes.CHA, AbilityTypes.valueOf("Charisma".substring(0, 3).toUpperCase()));
        assertEquals(AbilityTypes.CHA, AbilityTypes.valueOf("CHARISMA".substring(0, 3).toUpperCase()));

        assertNotEquals(AbilityTypes.STR, AbilityTypes.valueOf());
    }

}
