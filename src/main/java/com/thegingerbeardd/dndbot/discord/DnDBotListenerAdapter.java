package com.thegingerbeardd.dndbot.discord;

import com.thegingerbeardd.dndbot.party.Party;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DnDBotListenerAdapter extends ListenerAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(DnDBotListenerAdapter.class);
    private Party party;

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        LOGGER.debug("Received message from: " +
                event.getAuthor().getName() +
                "that says:\n " +
                event.getMessage().getContentDisplay());
    }

    public void addParty(Party party) {
        this.party = party;
    }
}
