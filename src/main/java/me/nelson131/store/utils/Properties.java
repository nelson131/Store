package me.nelson131.store.utils;

import static me.nelson131.store.Store.config;

public class Properties {

    public static String getCFG(String key){
        return config.get(key).toString();
    }
}
