package com.thegingerbeardd.dndbot.character.utils.fifthedition;

public enum AbilityTypes {
    STR("strength"),
    DEX("dexterity"),
    CON("constitution"),
    INT("intelligence"),
    WIS("wisdom"),
    CHA("charisma");

    private String val;

    AbilityTypes(String val) {
        this.val = val;
    }

    public String getType() {
        return val;
    }
}
