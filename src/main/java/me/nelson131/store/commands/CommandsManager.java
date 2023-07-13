package me.nelson131.store.commands;

import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.DefaultMemberPermissions;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

import java.util.ArrayList;
import java.util.List;

public class CommandsManager extends ListenerAdapter {

    @Override
    public void onGuildReady(GuildReadyEvent event){
        List<CommandData> cd = new ArrayList<>();

        cd.add(Commands.slash("setup", "Add channels and other thins for bot")
                .setDefaultPermissions(DefaultMemberPermissions.DISABLED));

        event.getGuild().updateCommands().addCommands(cd).queue();
    }
}
