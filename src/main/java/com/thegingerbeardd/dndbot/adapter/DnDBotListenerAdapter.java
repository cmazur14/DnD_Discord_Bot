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
        sendChat(event, messageProcessor.processInputMessage(event.getMessage().getContentRaw()));
    }

    private void sendChat(MessageReceivedEvent event, String msg) {
        event.getMessage().getChannel().sendMessage(msg).queue();
    }

}
