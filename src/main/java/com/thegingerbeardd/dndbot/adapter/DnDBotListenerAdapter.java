package com.thegingerbeardd.dndbot.adapter;

import com.thegingerbeardd.dndbot.party.Party;
import com.thegingerbeardd.dndbot.processor.impl.FifthEditionChatProcessor;
import com.thegingerbeardd.dndbot.utils.PartyPersistanceDAO;
import com.thegingerbeardd.dndbot.utils.PropertiesFileReader;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DnDBotListenerAdapter extends ListenerAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(DnDBotListenerAdapter.class);
    private FifthEditionChatProcessor messageProcessor;
    private static final PartyPersistanceDAO dao = PartyPersistanceDAO.getInstance();

    public void setMessageProcessor(FifthEditionChatProcessor processor) {
        messageProcessor = processor;
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot() || !event.getMessage().getContentRaw().startsWith("#ttbot"))
            return;
        String guildID = event.getMessage().getGuild().getId();
        messageProcessor.setParty(getActivePartyFor(guildID));
        logProcessing(event);
        sendChat(event, messageProcessor.processInputMessage(event.getMessage().getContentRaw()));
        checkIfSaveWorkedAndInformOnFailure(guildID, messageProcessor.getParty(), event);
    }

    private void checkIfSaveWorkedAndInformOnFailure(String guildID, Party party, MessageReceivedEvent event) {
        if (!saveActivePartyFor(guildID, party)) {
            LOGGER.debug("Failed to save party changes to disk");
            sendChat(event, "I was unable to save your changes to the party/characters if you made any, just be aware!");
        }
    }

    private void logProcessing(MessageReceivedEvent event) {
        if (event.getMember().getEffectiveName() != null)
            LOGGER.debug("Processing message: " + event.getMessage().getContentRaw() +
                    "\nfrom server: " + event.getMessage().getGuild().getName() +
                    "\nfrom user: " + event.getMember().getEffectiveName());
        else
            LOGGER.warn("Processing message: " + event.getMessage().getContentRaw() +
                    "\nfrom user via PM: " + event.getMessage().getAuthor().getName());
    }

    private Party getActivePartyFor(String guildID) {
        Party party = (Party) dao.readObjectFromTTBotSaveFile(guildID);
        if (party == null) {
            LOGGER.debug("Creating new party to be the persistent one for this channel");
            return new Party();
        }
        return party;
    }

    private Boolean saveActivePartyFor(String guildID, Party party) {
        return dao.saveObjectToTTBotSaveFile(party, guildID);
    }

    private void sendChat(MessageReceivedEvent event, String msg) {
        event.getMessage().getChannel().sendMessage(msg).queue();
    }

}
