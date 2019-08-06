package com.thegingerbeardd.dndbot.character.sheet;

import com.thegingerbeardd.dndbot.character.utils.fifthedition.AbilityTypes;

import java.util.ArrayList;
import java.util.List;

public class CharacterClass {

    protected String className;
    protected int currentLevel;
    protected AbilityTypes PROFICIENCY_1;
    protected AbilityTypes PROFICIENCY_2;

    String getClassName() {
        return className;
    };

    public int getCurrentLevel() {
        return currentLevel <= 0 || currentLevel > 20 ? 0 : currentLevel;
    }

    public void setCurrentLevel(int val) {
        currentLevel = val;
    }

    public List<AbilityTypes> getSaveProficiencyList() {
        List<AbilityTypes> proficiencies = new ArrayList<>();
        proficiencies.add(PROFICIENCY_1);
        proficiencies.add(PROFICIENCY_2);
        return proficiencies;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(className).append(" ")
                .append(currentLevel).toString();
    }

}
