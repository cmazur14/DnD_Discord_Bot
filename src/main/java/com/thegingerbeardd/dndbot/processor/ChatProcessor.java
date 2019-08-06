package com.thegingerbeardd.dndbot.processor;

import com.thegingerbeardd.dndbot.party.Party;

public interface ChatProcessor {

    String processInputMessage(String input);
    void setParty(Party party);

}
