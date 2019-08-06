package com.thegingerbeardd.dndbot.character.sheet;

import java.util.List;

public interface CharacterClass {

    String getClassName();
    int getCurrentLevel();
    void setCurrentLevel(int val);
    List<String> getSaveProficiencyList();

}
