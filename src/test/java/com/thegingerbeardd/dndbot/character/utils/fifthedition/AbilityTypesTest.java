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
        assertEquals(AbilityTypes.STR, AbilityTypes.getAbility("str"));
        assertEquals(AbilityTypes.STR, AbilityTypes.getAbility("STRENGTH"));
        assertEquals(AbilityTypes.STR, AbilityTypes.getAbility("Strength"));

        assertEquals(AbilityTypes.DEX, AbilityTypes.getAbility("dex"));
        assertEquals(AbilityTypes.DEX, AbilityTypes.getAbility("DEXTERITY"));
        assertEquals(AbilityTypes.DEX, AbilityTypes.getAbility("Dexterity"));

        assertEquals(AbilityTypes.CON, AbilityTypes.getAbility("con"));
        assertEquals(AbilityTypes.CON, AbilityTypes.getAbility("CONSTITUTION"));
        assertEquals(AbilityTypes.CON, AbilityTypes.getAbility("Constitution"));

        assertEquals(AbilityTypes.INT, AbilityTypes.getAbility("int"));
        assertEquals(AbilityTypes.INT, AbilityTypes.getAbility("INTELLIGENCE"));
        assertEquals(AbilityTypes.INT, AbilityTypes.getAbility("Intelligence"));

        assertEquals(AbilityTypes.WIS, AbilityTypes.getAbility("wis"));
        assertEquals(AbilityTypes.WIS, AbilityTypes.getAbility("WISDOM"));
        assertEquals(AbilityTypes.WIS, AbilityTypes.getAbility("Wisdom"));

        assertEquals(AbilityTypes.CHA, AbilityTypes.getAbility("cha"));
        assertEquals(AbilityTypes.CHA, AbilityTypes.getAbility("Charisma"));
        assertEquals(AbilityTypes.CHA, AbilityTypes.getAbility("CHARISMA"));

        assertNotEquals(AbilityTypes.STR, AbilityTypes.getAbility("constitution"));
        assertNotEquals(AbilityTypes.DEX, AbilityTypes.getAbility("constitution"));
        assertNotEquals(AbilityTypes.INT, AbilityTypes.getAbility("constitution"));
        assertNotEquals(AbilityTypes.WIS, AbilityTypes.getAbility("constitution"));
        assertNotEquals(AbilityTypes.CHA, AbilityTypes.getAbility("constitution"));
    }

}
