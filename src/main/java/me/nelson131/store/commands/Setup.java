package me.nelson131.store.commands;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.channel.concrete.Category;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.sql.SQLException;
import java.util.EnumSet;

import static me.nelson131.store.db.MySQL.setup;
import static me.nelson131.store.utils.Properties.getCFG;

public class Setup extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event){
        Guild guild = event.getGuild();
        Category category = guild.getCategoryById(getCFG("category-id"));

        if(event.getName().equals("setup")){
            int count = 1;

            while (count < 9){
                String nametag = getCFG("category"+count);

                TextChannel channel = guild.createTextChannel(nametag, category)
                        .addPermissionOverride(guild.getPublicRole(), EnumSet.of(Permission.VIEW_CHANNEL), EnumSet.of(Permission.CREATE_PUBLIC_THREADS, Permission.CREATE_PRIVATE_THREADS, Permission.MESSAGE_SEND))
                        .complete();
                channel.sendMessage("TEXT TEXT TEXT").queue();

                Long id = channel.getIdLong();
                Boolean slots = false;

                try {
                    setup(nametag, id, slots);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

                count++;
            }

            //TODO repair: ERROR RestAction - RestAction queue returned failure: [ErrorResponseException] 10062: Unknown interaction
            event.reply("finish").queue();

        }
    }
}
