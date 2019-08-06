package com.thegingerbeardd.dndbot.character;

import com.thegingerbeardd.dndbot.character.sheet.CharacterAbilityScores;
import com.thegingerbeardd.dndbot.character.sheet.CharacterSaveProficiencies;
import com.thegingerbeardd.dndbot.character.sheet.CharacterSkillProficiencies;

public class RollModifierCalculator {

    private CharacterAbilityScores abilityScores;
    private CharacterSkillProficiencies skillProficiencies;
    private CharacterSaveProficiencies saveProficiencies;

    /**
     * If the character that owns this calculator is proficient in the Saving Throw specified by savingThrowType,
     * this method will return the sum of the ability modifier and the proficiency modifier.
     *
     * If the character is not proficient, this will return only the ability modifier.
     *
     * @param savingThrowType SHOULD come from the relevant enum in the utils package for the edition you are using
     * @param overallLevel SHOULD be the sum of all class levels a character has, must be calculated by caller
     * @return the value of the modifier to be added to a d20 roll
     */
    public int getSavingThrowModifier(String savingThrowType, int overallLevel) {
        if (saveProficiencies.isProficientIn(savingThrowType))
            return abilityScores.getAbilityModifier(savingThrowType) + ((overallLevel - 1) / 4) + 2;
        return abilityScores.getAbilityModifier(savingThrowType);
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
