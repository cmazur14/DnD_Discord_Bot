package com.thegingerbeardd.dndbot.character;

import com.thegingerbeardd.dndbot.character.sheet.CharacterClass;

import java.util.ArrayList;
import java.util.List;

public class Character {

    private CharacterProperties properties;
    private String name;
    private List<CharacterClass> characterClasses;

    public Character(String name) {
        this.name = name;
        characterClasses = new ArrayList<CharacterClass>();
        properties = new CharacterProperties();
        properties.setOwner(this);
    }

    public CharacterProperties getProperties() {
        return properties;
    }
    //TODO move entire directory to path with no spaces in it

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CharacterClass> getCharacterClasses() {
        return characterClasses;
    }
}
