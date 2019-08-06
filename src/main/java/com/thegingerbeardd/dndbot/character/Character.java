package com.thegingerbeardd.dndbot.character;

import com.thegingerbeardd.dndbot.character.classes.ClassInitializer;
import com.thegingerbeardd.dndbot.character.classes.ClassList;
import com.thegingerbeardd.dndbot.character.sheet.CharacterClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Character {

    private String name;
    private List<String> characterClassList;
    private Map<String, CharacterClass> charClasses;

    public Character(String name) {
        this.name = name;
        characterClassList = new ArrayList<String>();
    }

    //TODO move entire directory to path with no spaces in it

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addClassLevel(ClassList charClass) {
        if (!characterClassList.contains(charClass.getClassName()))
            characterClassList.add(charClass.getClassName());
        if (charClasses.get(charClass.getClassName()) == null)
            charClasses.put(charClass.getClassName(), ClassInitializer.makeNewClass(charClass));
        CharacterClass classToIncreaseLevel = charClasses.get(charClass.getClassName());
        classToIncreaseLevel.setCurrentLevel(classToIncreaseLevel.getCurrentLevel() + 1);

    }

}
