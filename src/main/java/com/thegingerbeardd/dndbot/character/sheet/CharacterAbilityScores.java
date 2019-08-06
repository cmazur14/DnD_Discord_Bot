package com.thegingerbeardd.dndbot.character.sheet;

import java.util.HashMap;
import java.util.Map;

public class CharacterAbilityScores {

    private Map<String, Integer> abilityScores;

    public CharacterAbilityScores() {
        abilityScores = new HashMap<String, Integer>();
    }

    public void setAbilityScore(String abilityType, int val) {
        abilityScores.put(abilityType, val);
    }

    public void fillAbilityScores(Map<String, Integer> scores) {
        abilityScores = scores;
    }

    public int getAbilityScore(String abilityType) {
        return abilityScores.get(abilityType);
    }

    public int getAbilityModifier(String abilityType) {
        return (abilityScores.get(abilityType) - 10) / 2;
    }
}
