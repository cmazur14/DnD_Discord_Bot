package com.thegingerbeardd.dndbot.character.sheet;

public class CharacterClass {
    public boolean ChaSaveProficient;
    public boolean WisSaveProficient;
    public boolean IntSaveProficient;
    public boolean ConSaveProficient;
    public boolean DexSaveProficient;
    public boolean StrSaveProficient;

    public int currentCharacterLevel;

    public CharacterClass() {
        currentCharacterLevel = 1;
        ChaSaveProficient = false;
        WisSaveProficient = false;
        IntSaveProficient = false;
        ConSaveProficient = false;
        DexSaveProficient = false;
        StrSaveProficient = false;
    }
}
