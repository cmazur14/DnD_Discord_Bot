package com.thegingerbeardd.dndbot.character.sheet;

import com.thegingerbeardd.dndbot.character.utils.fifthedition.AbilityTypes;

import java.util.HashMap;
import java.util.Map;

public class CharacterSaveProficiencies {

    private Map<AbilityTypes, Boolean> proficiencies;

    public CharacterSaveProficiencies() {
        proficiencies = new HashMap<>();
        for (AbilityTypes type : AbilityTypes.values()) {
            proficiencies.put(type, false);
        }
    }

    public CharacterSaveProficiencies(CharacterClass charClass) {
        proficiencies = new HashMap<>();
        for (AbilityTypes s : charClass.getSaveProficiencyList())
            proficiencies.put(s, true);
    }

    public void updateProficienciesBasedOnNewClass(CharacterClass charClass) {
        for (AbilityTypes s : charClass.getSaveProficiencyList())
            proficiencies.put(s, true);
    }

    public void makeProficientIn(AbilityTypes saveType) {
        proficiencies.put(saveType, true);
    }

    public void makeNotProficientIn(AbilityTypes saveType) {
        proficiencies.put(saveType, false);
    }

    public boolean isProficientIn(AbilityTypes saveType) {
        return proficiencies.get(saveType);
    }

}
