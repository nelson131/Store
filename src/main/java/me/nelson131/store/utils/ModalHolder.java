package me.nelson131.store.utils;

import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.text.TextInput;
import net.dv8tion.jda.api.interactions.components.text.TextInputStyle;
import net.dv8tion.jda.api.interactions.modals.Modal;

import static me.nelson131.store.utils.Properties.getCFG;

public class ModalHolder {

    public static Modal add(){
        TextInput title = TextInput.create("title", getCFG("add-title"), TextInputStyle.SHORT)
                .setPlaceholder(getCFG("add-title-pl"))
                .setRequired(true)
                .build();
        TextInput desc = TextInput.create("desc", getCFG("add-desc"), TextInputStyle.PARAGRAPH)
                .setPlaceholder(getCFG("add-desc-pl"))
                .setRequired(true)
                .build();
        TextInput cost = TextInput.create("cost", getCFG("add-cost"), TextInputStyle.SHORT)
                .setPlaceholder(getCFG("add-cost-pl"))
                .setRequired(true)
                .build();
        TextInput url = TextInput.create("url", getCFG("add-url"), TextInputStyle.SHORT)
                .setPlaceholder(getCFG("add-url-pl"))
                .setRequired(true)
                .build();

        Modal modal = Modal.create("add", getCFG("add-name"))
                .addActionRows(ActionRow.of(title), ActionRow.of(desc), ActionRow.of(cost), ActionRow.of(url))
                .build();

        return modal;
    }

    public static Modal remove(){
        TextInput slot = TextInput.create("slot", getCFG("remove-slot"), TextInputStyle.SHORT)
                .setPlaceholder(getCFG("remove-slot-pl"))
                .setRequired(true)
                .build();

        Modal modal = Modal.create("remove", getCFG("remove-name"))
                .addActionRow(slot)
                .build();

        return modal;
    }

    public static Modal get(){
        TextInput category = TextInput.create("category", getCFG("get-ct"), TextInputStyle.SHORT)
                .setPlaceholder(getCFG("get-ct-pl"))
                .setRequired(true)
                .build();

        Modal modal = Modal.create("get", getCFG("get-name"))
                .addActionRow(category)
                .build();

        return modal;
    }
}
