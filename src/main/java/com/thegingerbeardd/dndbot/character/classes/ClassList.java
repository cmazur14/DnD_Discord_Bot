package com.thegingerbeardd.dndbot.character.classes;

public enum ClassList {
    BARBARIAN("Barbarian");
    //TODO implement the rest of this enum once the rest of the classes are implemented

    private String val;

    ClassList(String val) {
        this.val = val;
    }

    public String getClassName() {
        return val;
    }
}
