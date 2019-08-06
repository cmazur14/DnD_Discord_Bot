package com.thegingerbeardd.dndbot.character;

import com.thegingerbeardd.dndbot.character.sheet.CharacterAbilityScores;
import com.thegingerbeardd.dndbot.character.sheet.CharacterClass;

import java.util.List;

public class CharacterProperties {
    private Character owner;
    public int overallLevel;
    public CharacterAbilityScores abilityScores;

    public CharacterAbilityScores getAbilityScores() {
        return abilityScores;
    }

    public int getProficiencyMod() {
        forceUpdateOverallLevel();
        return ((overallLevel - 1) / 4) + 2;
    }

    public void setOwner(Character owner) {
        this.owner = owner;
    }

    public Character getOwner() {
        return owner;
    }

    private void forceUpdateOverallLevel() {
        overallLevel = 0;
        for (CharacterClass charClass : owner.getCharacterClasses())
            overallLevel += charClass.currentCharacterLevel;
    }

    public boolean isProficientInAcrobatics;
    public boolean isProficientInAnimalHandling;
    public boolean isProficientInArcana;
    public boolean isProficientInAthletics;
    public boolean isProficientInDeception;
    public boolean isProficientInHistory;
    public boolean isProficientInInsight;
    public boolean isProficientInIntimidation;
    public boolean isProficientInInvestigation;
    public boolean isProficientInMedicine;
    public boolean isProficientInNature;
    public boolean isProficientInPerception;
    public boolean isProficientInPerformance;
    public boolean isProficientInPersuasion;
    public boolean isProficientInReligion;
    public boolean isProficientInSleightOfHand;
    public boolean isProficientInStealth;
    public boolean isProficientInSurvival;
}
