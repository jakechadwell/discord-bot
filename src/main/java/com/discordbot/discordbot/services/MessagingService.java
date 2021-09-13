package com.discordbot.discordbot.services;

import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.MessageAuthor;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;

import java.awt.*;
import java.util.concurrent.CompletableFuture;

public interface MessagingService{
    CompletableFuture<Message> sendMessage(MessageAuthor author, String title, String description, String footer, String thumbnail, TextChannel channel);

    public void sendMessage(MessageAuthor author, String title, String description, String footer, String thumbnail, TextChannel channel, boolean withDelete);
}
