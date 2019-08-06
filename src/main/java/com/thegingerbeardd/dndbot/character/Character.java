package com.thegingerbeardd.dndbot.character;

import com.thegingerbeardd.dndbot.character.classes.ClassInitializer;
import com.thegingerbeardd.dndbot.character.classes.ClassList;
import com.thegingerbeardd.dndbot.character.sheet.CharacterClass;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Character {

    private String name;

    private Map<String, CharacterClass> charClasses;

    public Character(String name) {
        this.name = name;
        charClasses = new HashMap<String, CharacterClass>();
    }

    //TODO move entire directory to path with no spaces in it

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                .append(name)
                .append(" is a ")
                .append(getClassListAsString())
                .toString();
    }

}
