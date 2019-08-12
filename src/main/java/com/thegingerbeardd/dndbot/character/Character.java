package com.thegingerbeardd.dndbot.character;

import com.thegingerbeardd.dndbot.character.classes.ClassInitializer;
import com.thegingerbeardd.dndbot.character.classes.ClassList;
import com.thegingerbeardd.dndbot.character.sheet.CharacterAbilityScores;
import com.thegingerbeardd.dndbot.character.sheet.CharacterClass;
import com.thegingerbeardd.dndbot.character.sheet.CharacterSaveProficiencies;
import com.thegingerbeardd.dndbot.character.utils.fifthedition.AbilityTypes;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Character implements Serializable {

    private String name;
    private CharacterAbilityScores abilityScores;
    private CharacterSaveProficiencies saveProficiencies;
    private Map<String, CharacterClass> charClasses;

    public Character(String name) {
        this.name = name.toUpperCase();
        abilityScores = new CharacterAbilityScores();
        saveProficiencies = new CharacterSaveProficiencies();
        charClasses = new HashMap<>();
    }

    public static Character generateRandomCharacterWithName(String name) {
        Random rng = new Random();
        Character toReturn = new Character(name);
        toReturn.addClassLevel(ClassList.values()[rng.nextInt(ClassList.values().length)]);
        for (AbilityTypes type : AbilityTypes.values()) {
            toReturn.setAbilityScore(type, rng.nextInt(20));
        }
        return toReturn;
    }

    private void setAbilityScore(AbilityTypes type, int value) {
        abilityScores.setAbilityScore(type, value);
    }

    //TODO move entire directory to path with no spaces in it

    public String getName() {
        return StringUtils.capitalize(name.toLowerCase());
    }

    public void setName(String name) {
        this.name = name.toUpperCase();
    }

    public int getCurrentCharacterLevel() {
        int toReturn = 0;
        for (String s : charClasses.keySet())
            toReturn += charClasses.get(s).getCurrentLevel();
        return toReturn;
    }

    public void addClassLevel(ClassList charClass) {
        if (charClasses.get(charClass.getClassName()) == null)
            charClasses.put(charClass.getClassName(), ClassInitializer.makeNewClass(charClass));
        CharacterClass classToIncreaseLevel = charClasses.get(charClass.getClassName());
        classToIncreaseLevel.setCurrentLevel(classToIncreaseLevel.getCurrentLevel() + 1);
        for (AbilityTypes type : classToIncreaseLevel.getSaveProficiencyList()) {
            saveProficiencies.makeProficientIn(type);
        }
    }

    public String getClassListAsString() {
        StringBuilder toReturn = new StringBuilder();
        if (charClasses.keySet().isEmpty())
            return "";
        for (String s : charClasses.keySet())
            toReturn.append("level ")
                    .append(charClasses.get(s))
                    .append(", ");
        return toReturn.toString().substring(0, toReturn.toString().length()-2);
    }

    public Set<String> getClassList() {
        return charClasses.keySet();
    }

    @Override
    public String toString() {
        if (getClassListAsString().isEmpty())
            return StringUtils.capitalize(name.toLowerCase()) + ", a wimpy little shit who can't do anything and is still level 0";
        else
            return new StringBuilder()
                    .append(StringUtils.capitalize(name.toLowerCase()))
                    .append(", a ")
                    .append(getClassListAsString())
                    .toString();
    }

    public boolean isProficientIn(AbilityTypes savingThrowType) {
        return saveProficiencies.isProficientIn(savingThrowType);
    }

    public CharacterAbilityScores getAbilityScores() {
        return abilityScores;
    }
}
