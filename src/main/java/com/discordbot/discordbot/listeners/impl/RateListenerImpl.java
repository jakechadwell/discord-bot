package com.discordbot.discordbot.listeners.impl;

import com.discordbot.discordbot.listeners.RateListener;
import com.discordbot.discordbot.services.MessagingService;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class RateListenerImpl implements RateListener {
    private final static Pattern pattern = Pattern.compile("!rate (\\w+)");

    @Autowired
    private MessagingService messagingService;

    @Override
    public void onMessageCreate(MessageCreateEvent messageCreateEvent){
        if(messageCreateEvent.getMessageContent().startsWith("!rate")){
            Matcher matcher = pattern.matcher(messageCreateEvent.getMessageContent());
            if(matcher.matches()) {
//                Do rating
                int rating = (int) Math.floor(Math.random() * 100) + 1;
                messagingService.sendMessage(messageCreateEvent.getMessageAuthor(),
                        "Rate calculator",
                        messageCreateEvent.getMessageAuthor().getDisplayName() + " is " + rating + "% " + matcher.group(1),
                        "Rate again?",
                        "https://static4.depositphotos.com/1006890/353/i/600/depositphotos_3533048-stock-photo-percent.jpg",
                        messageCreateEvent.getChannel());
            } else {
//                Give Syntax Help
                messagingService.sendMessage(messageCreateEvent.getMessageAuthor(),
                        "Rate calculator",
                        "Are you trying to use the !rate command? Please use the correct syntax and try again.",
                        "Rate again?",
                        null,
                        messageCreateEvent.getChannel(), true);
            }
        }
    }
}
