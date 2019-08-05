package com.thegingerbeardd.dndbot.party;

import java.util.ArrayList;
import java.util.List;
import com.thegingerbeardd.dndbot.character.Character;

public class Party {

    private List<Character> charactersInParty;

    public Party() {
        charactersInParty = new ArrayList<Character>();
    }

    public void addPartyMember(Character ch) {
        charactersInParty.add(ch);
    }

    public void addNewPartyMemberWithName(String name) {
        charactersInParty.add(new Character(name));
    }

}
