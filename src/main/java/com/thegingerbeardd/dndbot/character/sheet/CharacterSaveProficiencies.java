package com.thegingerbeardd.dndbot.character.sheet;

import com.thegingerbeardd.dndbot.character.utils.fifthedition.AbilityTypes;

import java.util.Map;

public class CharacterSaveProficiencies {

    private Map<String, Boolean> proficiencies;

    public CharacterSaveProficiencies() {
        for (AbilityTypes type : AbilityTypes.values()) {
            proficiencies.put(type.getType(), false);
        }
    }

    public CharacterSaveProficiencies(CharacterClass charClass) {
        for (String s : charClass.getSaveProficiencyList())
            proficiencies.put(s, true);
    }

    public void makeProficientIn(String saveType) {
        proficiencies.put(saveType, true);
    }

    public void makeNotProficientIn(String saveType) {
        proficiencies.put(saveType, false);
    }

    public boolean isProficientIn(String saveType) {
        return proficiencies.get(saveType);
    }

}
