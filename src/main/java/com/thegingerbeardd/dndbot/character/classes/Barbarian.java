package com.thegingerbeardd.dndbot.character.classes;

import com.thegingerbeardd.dndbot.character.sheet.CharacterClass;
import com.thegingerbeardd.dndbot.character.utils.fifthedition.AbilityTypes;

import java.util.ArrayList;
import java.util.List;

public class Barbarian extends CharacterClass {

    public Barbarian() {
        PROFICIENCY_1 = AbilityTypes.STRENGTH;
        PROFICIENCY_2 = AbilityTypes.CONSTITUTION;
        className = ClassList.BARBARIAN.getClassName();
        currentLevel = 0;
    }

}
