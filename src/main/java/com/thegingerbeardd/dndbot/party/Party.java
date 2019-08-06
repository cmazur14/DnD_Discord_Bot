package com.thegingerbeardd.dndbot.party;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.thegingerbeardd.dndbot.character.Character;

public class Party {

    private Map<String, Character> charactersInParty;

    public Party() {
        charactersInParty = new HashMap<String, Character>();
    }

    public void addPartyMember(Character ch) {
        charactersInParty.put(ch.getName(), ch);
    }

    public void addNewPartyMemberWithName(String name) {
        charactersInParty.put(name, new Character(name));
    }

    public Character getPartyMemberWithName(String name) {
        return charactersInParty.get(name);
    }

    public List<Character> getAllCharactersInParty() {
        List<Character> toReturn = new ArrayList<>();
        for (String s : charactersInParty.keySet()) {
            toReturn.add(charactersInParty.get(s));
        }
        return toReturn;
    }

    @Override
    public String toString() {
        StringBuilder toReturn = new StringBuilder().append("\n");
        for (String ch : charactersInParty.keySet()) {
            toReturn.append(charactersInParty.get(ch))
                .append("\n");
        }
        return toReturn.toString();
    }

    public boolean containsPartyMember(String input) {
        for (String ch : charactersInParty.keySet()) {
            if (input.equals(ch))
                return true;
        }
        return false;
    }
}
