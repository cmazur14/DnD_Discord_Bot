package com.thegingerbeardd.dndbot.character.utils.fifthedition;

public enum AbilityTypes {
    STR,
    DEX,
    CON,
    INT,
    WIS,
    CHA;

    public static AbilityTypes getAbility(String str) {
        return AbilityTypes.valueOf(str.substring(0, 3).toUpperCase());
    }
}
