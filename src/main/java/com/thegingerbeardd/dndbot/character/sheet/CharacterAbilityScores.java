package com.thegingerbeardd.dndbot.character.sheet;

import com.thegingerbeardd.dndbot.character.utils.fifthedition.AbilityTypes;

import java.util.HashMap;
import java.util.Map;

public class CharacterAbilityScores {

    private Map<AbilityTypes, Integer> abilityScores;

    public CharacterAbilityScores() {
        abilityScores = new HashMap<>();
    }

    public void setAbilityScore(AbilityTypes abilityType, int val) {
        abilityScores.put(abilityType, val);
    }

    public void fillAbilityScores(Map<AbilityTypes, Integer> scores) {
        abilityScores = scores;
    }

    public int getAbilityScore(AbilityTypes abilityType) {
        return abilityScores.get(abilityType);
    }

    public int getAbilityModifier(AbilityTypes abilityType) {
        return (abilityScores.get(abilityType) - 10) / 2;
    }
}
