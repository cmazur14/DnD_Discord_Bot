package com.thegingerbeardd.dndbot.character.sheet;

import com.thegingerbeardd.dndbot.character.CharacterProperties;

public class CharacterAbilityScores {
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public int getChaModifier() {
        return (charisma - 10) / 2;
    }

    public int getWisModifier() {
        return (wisdom - 10) / 2;
    }

    public int getConModifier() {
        return (constitution - 10) / 2;
    }

    public int getIntModifier() {
        return (intelligence - 10) / 2;
    }

    public int getDexModifier() {
        return (dexterity - 10) / 2;
    }

    public int getStrModifier() {
        return (strength - 10) / 2;
    }

    public int getChaSaveModifier(CharacterProperties prop) {
        int toReturn = getChaModifier();
        for (CharacterClass charClass : prop.CharacterClasses) {
            if (charClass.ChaSaveProficient) {
                toReturn += prop.getProficiencyMod();
                break;
            }
        }
        return toReturn;
    }

    public int getWisSaveModifier(CharacterProperties prop) {
        int toReturn = getWisModifier();
        for (CharacterClass charClass : prop.CharacterClasses) {
            if (charClass.WisSaveProficient) {
                toReturn += prop.getProficiencyMod();
                break;
            }
        }
        return toReturn;
    }

    public int getIntSaveModifier(CharacterProperties prop) {
        int toReturn = getIntModifier();
        for (CharacterClass charClass : prop.CharacterClasses) {
            if (charClass.IntSaveProficient) {
                toReturn += prop.getProficiencyMod();
                break;
            }
        }
        return toReturn;
    }

    public int getConSaveModifier(CharacterProperties prop) {
        int toReturn = getConModifier();
        for (CharacterClass charClass : prop.CharacterClasses) {
            if (charClass.ConSaveProficient) {
                toReturn += prop.getProficiencyMod();
                break;
            }
        }
        return toReturn;
    }

    public int getDexSaveModifier(CharacterProperties prop) {
        int toReturn = getDexModifier();
        for (CharacterClass charClass : prop.CharacterClasses) {
            if (charClass.DexSaveProficient) {
                toReturn += prop.getProficiencyMod();
                break;
            }
        }
        return toReturn;
    }

    public int getStrSaveModifier(CharacterProperties prop) {
        int toReturn = getStrModifier();
        for (CharacterClass charClass : prop.CharacterClasses) {
            if (charClass.StrSaveProficient) {
                toReturn += prop.getProficiencyMod();
                break;
            }
        }
        return toReturn;
    }

}
