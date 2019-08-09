package com.thegingerbeardd.dndbot.adapter;

import com.thegingerbeardd.dndbot.processor.impl.FifthEditionChatProcessor;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DnDBotListenerAdapter extends ListenerAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(DnDBotListenerAdapter.class);
    private FifthEditionChatProcessor messageProcessor;

    public void setMessageProcessor(FifthEditionChatProcessor processor) {
        messageProcessor = processor;
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot() || !event.getMessage().getContentRaw().startsWith("#ttbot")) {
            LOGGER.debug("Ignoring message: " + event.getMessage().getContentRaw());
            return;
        }
        //TODO implement filesaving/loading based on event.getGuild().getName(); because a guild is the
        //TODO serverside name for a channel, potentially adding on an .getGuild.getOwner_ID just in case any
        //TODO servers are named the same way
        if (event.getMember().getEffectiveName() != null)
            LOGGER.debug("Processing message from: " + event.getMember().getEffectiveName() + event.getMessage().getContentRaw());
        else
            LOGGER.warn("Processing message from private channel: " + event.getMessage().getContentRaw());
        sendChat(event, messageProcessor.processInputMessage(event.getMessage().getContentRaw()));
    }

    private void sendChat(MessageReceivedEvent event, String msg) {
        event.getMessage().getChannel().sendMessage(msg).queue();
    }

}
