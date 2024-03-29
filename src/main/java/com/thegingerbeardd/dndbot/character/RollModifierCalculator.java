package com.thegingerbeardd.dndbot.character;

import com.thegingerbeardd.dndbot.character.sheet.CharacterAbilityScores;
import com.thegingerbeardd.dndbot.character.sheet.CharacterSaveProficiencies;
import com.thegingerbeardd.dndbot.character.sheet.CharacterSkillProficiencies;
import com.thegingerbeardd.dndbot.character.utils.fifthedition.AbilityTypes;

public class RollModifierCalculator {

    private static RollModifierCalculator instance;

    public static RollModifierCalculator getInstance() {
        if (instance == null)
            instance = new RollModifierCalculator();
        return instance;
    }

    /**
     * If the character that owns this calculator is proficient in the Saving Throw specified by savingThrowType,
     * this method will return the sum of the ability modifier and the proficiency modifier.
     *
     * If the character is not proficient, this will return only the ability modifier.
     *
     * @param savingThrowType SHOULD come from the relevant enum in the utils package for the edition you are using
     * @param ch should be the character this call is being made for
     * @return the value of the modifier to be added to a d20 roll
     */
    public int getSavingThrowModifier(AbilityTypes savingThrowType, Character ch) {
        if (ch.isProficientIn(savingThrowType))
            return ch.getAbilityScores().getAbilityModifier(savingThrowType) + ((ch.getCurrentCharacterLevel() - 1) / 4) + 2;
        return ch.getAbilityScores().getAbilityModifier(savingThrowType);
        //TODO fix this entire class to specify that this calculates 5th edition rules only
        //TODO unit-test this method
    }

    public int getSkillRollModifier(String skillType) {
        //TODO implement this in relevant children
        return 0;
    }

    public int getAbilityCheck(String abilityType) {
        //TODO implement this in relevant children
        return 0;
    }

}
