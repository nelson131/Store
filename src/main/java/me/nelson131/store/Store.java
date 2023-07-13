package me.nelson131.store;

import me.nelson131.store.commands.CommandsManager;
import me.nelson131.store.commands.Setup;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static me.nelson131.store.utils.Properties.getCFG;

public class Store {

    public static final Properties config = new Properties();

    private static JDA jda;

    public static void main(String[] args) throws IOException, InterruptedException {
        config.load(new FileInputStream("config.properties"));

        jda = JDABuilder.createDefault(getCFG("bot-token"))
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .setActivity(Activity.watching(getCFG("activity-watching")))
                .addEventListeners(new CommandsManager(), new Setup())
                .build();

        jda.awaitReady();
    }
}
