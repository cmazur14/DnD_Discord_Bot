package com.thegingerbeardd.dndbot.character.utils.fifthedition;

public enum AbilityTypes {
    STRENGTH("str"),
    DEXTERITY("dex"),
    CONSTITUTION("con"),
    INTELLIGENCE("int"),
    WISDOM("wis"),
    CHARISMA("cha");

    private String val;

    AbilityTypes(String val) {
        this.val = val;
    }

    public String getType() {
        return val;
    }
}
