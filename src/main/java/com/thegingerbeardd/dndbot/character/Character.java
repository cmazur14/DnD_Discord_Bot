package com.thegingerbeardd.dndbot.character;

import com.sun.xml.internal.ws.util.StringUtils;
import com.thegingerbeardd.dndbot.character.classes.ClassInitializer;
import com.thegingerbeardd.dndbot.character.classes.ClassList;
import com.thegingerbeardd.dndbot.character.sheet.CharacterAbilityScores;
import com.thegingerbeardd.dndbot.character.sheet.CharacterClass;
import com.thegingerbeardd.dndbot.character.sheet.CharacterSaveProficiencies;
import com.thegingerbeardd.dndbot.character.sheet.CharacterSkillProficiencies;
import com.thegingerbeardd.dndbot.character.utils.fifthedition.AbilityTypes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Character {

    private String name;
    private CharacterAbilityScores abilityScores;
    private CharacterSkillProficiencies skillProficiencies;
    private CharacterSaveProficiencies saveProficiencies;
    private Map<String, CharacterClass> charClasses;

    public Character(String name) {
        this.name = name.toUpperCase();
        abilityScores = new CharacterAbilityScores();
        skillProficiencies = new CharacterSkillProficiencies();
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
        for (String s : charClasses.keySet())
            toReturn.append(charClasses.get(s)).append(", ");
        return toReturn.toString();
    }

    public Set<String> getClassList() {
        return charClasses.keySet();
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(StringUtils.capitalize(name.toLowerCase()))
                .append(", a level ")
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
