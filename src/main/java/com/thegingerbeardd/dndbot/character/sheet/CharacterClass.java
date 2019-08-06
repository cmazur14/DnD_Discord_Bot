package com.thegingerbeardd.dndbot.character.sheet;

import java.util.List;

public interface CharacterClass {

    String getClassName();
    int getCurrentLevel();
    List<String> getSaveProficiencyList();

}
