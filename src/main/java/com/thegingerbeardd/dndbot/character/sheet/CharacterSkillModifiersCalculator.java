package com.thegingerbeardd.dndbot.character.sheet;

import com.thegingerbeardd.dndbot.character.CharacterProperties;

class CharacterSkillModifiersCalculator {

    public int getAcrobaticsMod(CharacterAbilityScores scores, CharacterProperties character) {
        int returnValue = scores.getDexModifier();
        if (character.isProficientInAcrobatics)
            returnValue += (character.getProficiencyMod());
        return returnValue;
    }
    public int getAnimalHandlingMod(CharacterAbilityScores scores, CharacterProperties character) {
        int returnValue = scores.getWisModifier();
        if (character.isProficientInAnimalHandling)
            returnValue += (character.getProficiencyMod());
        return returnValue;
    }
    public int getArcanaMod(CharacterAbilityScores scores, CharacterProperties character) {
        int returnValue = scores.getIntModifier();
        if (character.isProficientInArcana)
            returnValue += (character.getProficiencyMod());
        return returnValue;
    }
    public int getAthleticsMod(CharacterAbilityScores scores, CharacterProperties character) {
        int returnValue = scores.getStrModifier();
        if (character.isProficientInAthletics)
            returnValue += (character.getProficiencyMod());
        return returnValue;
    }
    public int getDeceptionMod(CharacterAbilityScores scores, CharacterProperties character) {
        int returnValue = scores.getChaModifier();
        if (character.isProficientInDeception)
            returnValue += (character.getProficiencyMod());
        return returnValue;
    }
    public int getHistoryMod(CharacterAbilityScores scores, CharacterProperties character) {
        int returnValue = scores.getIntModifier();
        if (character.isProficientInHistory)
            returnValue += (character.getProficiencyMod());
        return returnValue;
    }
    public int getInsightMod(CharacterAbilityScores scores, CharacterProperties character) {
        int returnValue = scores.getWisModifier();
        if (character.isProficientInInsight)
            returnValue += (character.getProficiencyMod());
        return returnValue;
    }
    public int getIntimidationMod(CharacterAbilityScores scores, CharacterProperties character) {
        int returnValue = scores.getChaModifier();
        if (character.isProficientInIntimidation)
            returnValue += (character.getProficiencyMod());
        return returnValue;
    }
    public int getInvestigationMod(CharacterAbilityScores scores, CharacterProperties character) {
        int returnValue = scores.getIntModifier();
        if (character.isProficientInInvestigation)
            returnValue += (character.getProficiencyMod());
        return returnValue;
    }
    public int getMedicineMod(CharacterAbilityScores scores, CharacterProperties character) {
        int returnValue = scores.getWisModifier();
        if (character.isProficientInMedicine)
            returnValue += (character.getProficiencyMod());
        return returnValue;
    }
    public int getNatureMod(CharacterAbilityScores scores, CharacterProperties character) {
        int returnValue = scores.getIntModifier();
        if (character.isProficientInNature)
            returnValue += (character.getProficiencyMod());
        return returnValue;
    }
    public int getPerceptionMod(CharacterAbilityScores scores, CharacterProperties character) {
        int returnValue = scores.getWisModifier();
        if (character.isProficientInPerception)
            returnValue += (character.getProficiencyMod());
        return returnValue;
    }
    public int getPerformanceMod(CharacterAbilityScores scores, CharacterProperties character) {
        int returnValue = scores.getChaModifier();
        if (character.isProficientInPerformance)
            returnValue += (character.getProficiencyMod());
        return returnValue;
    }
    public int getPersuasionMod(CharacterAbilityScores scores, CharacterProperties character) {
        int returnValue = scores.getChaModifier();
        if (character.isProficientInPersuasion)
            returnValue += (character.getProficiencyMod());
        return returnValue;
    }
    public int getReligionMod(CharacterAbilityScores scores, CharacterProperties character) {
        int returnValue = scores.getIntModifier();
        if (character.isProficientInReligion)
            returnValue += (character.getProficiencyMod());
        return returnValue;
    }
    public int getSleightOfHandMod(CharacterAbilityScores scores, CharacterProperties character) {
        int returnValue = scores.getDexModifier();
        if (character.isProficientInSleightOfHand)
            returnValue += (character.getProficiencyMod());
        return returnValue;
    }
    public int getStealthMod(CharacterAbilityScores scores, CharacterProperties character) {
        int returnValue = scores.getDexModifier();
        if (character.isProficientInStealth)
            returnValue += (character.getProficiencyMod());
        return returnValue;
    }
    public int getSurvivalMod(CharacterAbilityScores scores, CharacterProperties character) {
        int returnValue = scores.getWisModifier();
        if (character.isProficientInSurvival)
            returnValue += (character.getProficiencyMod());
        return returnValue;
    }

}
