package com.thegingerbeardd.dndbot.character.sheet;

import java.util.List;

public interface CharacterClass {

    public boolean getSaveProficient(String saveType);
    public List<String> getSaveProficiencyList();

}
