package com.thegingerbeardd.dndbot.character.classes;

import com.thegingerbeardd.dndbot.character.sheet.CharacterClass;

public class ClassInitializer {
    public static CharacterClass makeNewClass(ClassList charClass) {
        switch (charClass) {
            case BARBARIAN:
                return new Barbarian();
        }
        return null;
    }
}
