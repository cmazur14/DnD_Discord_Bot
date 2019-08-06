package com.thegingerbeardd.dndbot.discord;

import com.thegingerbeardd.dndbot.party.Party;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;

import java.util.Arrays;

public class DnDBotListenerAdapter extends ListenerAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(DnDBotListenerAdapter.class);
    private Party party;

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot() || !event.getMessage().getContentRaw().startsWith("dnd")) {
            LOGGER.debug("Ignoring message: " + event.getMessage().getContentRaw());
            return;
        }
        String[] inputs = event.getMessage().getContentRaw().split(" ", -1);
        event.getMessage().getChannel().sendMessage("Received message with tokens: " + Arrays.toString(inputs)).queue();
        LOGGER.debug("Received message with tokens: " + Arrays.toString(inputs));
    }

    public void addParty(Party party) {
        this.party = party;
    }
}
