package com.thegingerbeardd.dndbot.character.classes;

import com.thegingerbeardd.dndbot.character.sheet.CharacterClass;
import com.thegingerbeardd.dndbot.character.utils.fifthedition.AbilityTypes;

import java.util.ArrayList;
import java.util.List;

public class Barbarian implements CharacterClass {

    private static final String CLASS_NAME = "BARBARIAN";
    private int currentLevel;
    private static final String PROFICIENCY_1 = AbilityTypes.STRENGTH.getType();
    private static final String PROFICIENCY_2 = AbilityTypes.CONSTITUTION.getType();

    public String getClassName() {
        return CLASS_NAME;
    }

    public static String getStaticClassName() {
        return CLASS_NAME;
    }

    public int getCurrentLevel() {
        return currentLevel <= 0 || currentLevel > 20 ? 0 : currentLevel;
    }

    public List<String> getSaveProficiencyList() {
        List<String> proficiencies = new ArrayList<String>();
        proficiencies.add(PROFICIENCY_1);
        proficiencies.add(PROFICIENCY_2);
        return proficiencies;
    }

    public void setCurrentLevel(int val) {
        currentLevel = val;
    }
}
