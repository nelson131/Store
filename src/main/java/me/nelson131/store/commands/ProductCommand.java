package me.nelson131.store.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import static me.nelson131.store.utils.ModalHolder.*;

public class ProductCommand extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event){

        if (event.getName().equals("product")) {

            switch (event.getOption("function").getAsString()){
                case "add":
                    event.replyModal(add()).queue();
                    return;
                case "remove":
                    event.replyModal(remove()).queue();
                    return;
                case "get":
                    event.replyModal(get()).queue();
            }
        }
    }
}
