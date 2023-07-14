package me.nelson131.store.utils;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;

import java.awt.*;

import static me.nelson131.store.utils.Properties.getCFG;

public class MessageHolder {

    public static final Color bot =  new Color(212, 132, 28);
    public static final Color error = new Color(255, 0, 0);

    public static MessageEmbed categoriesMessage(String name){
        EmbedBuilder ed = new EmbedBuilder();
        ed.setColor(bot);
        ed.setTitle(getCFG("categories-title") + " " + name + ": ");
        return ed.build();
    }

}
