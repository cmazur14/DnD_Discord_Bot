package com.thegingerbeardd.dndbot.character.classes;

import com.thegingerbeardd.dndbot.character.sheet.CharacterClass;
import com.thegingerbeardd.dndbot.character.utils.fifthedition.AbilityTypes;

public class Barbarian extends CharacterClass {

    public Barbarian() {
        PROFICIENCY_1 = AbilityTypes.STR;
        PROFICIENCY_2 = AbilityTypes.CON;
        className = ClassList.BARBARIAN.getClassName();
        currentLevel = 0;
    }

}
