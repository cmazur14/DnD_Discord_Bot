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
        charactersInParty.put(ch.getName().toUpperCase(), ch);
    }

    public void addNewPartyMemberWithName(String name) {
        charactersInParty.put(name.toUpperCase(), new Character(name.toUpperCase()));
    }

    public Character getPartyMemberWithName(String name) {
        return charactersInParty.get(name.toUpperCase());
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
        StringBuilder toReturn = new StringBuilder().append("The party is made up of: \n");
        for (String ch : charactersInParty.keySet()) {
            toReturn.append("\t-")
                    .append(charactersInParty.get(ch))
                    .append("\n");
        }
        return toReturn.toString().substring(0, toReturn.toString().length() - 1);
    }

    public boolean containsPartyMember(String input) {
        for (String ch : charactersInParty.keySet()) {
            if (input.equals(ch.toUpperCase()))
                return true;
        }
        return false;
    }
}
