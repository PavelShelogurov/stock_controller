package dev.stockController.utils;

import java.util.ResourceBundle;

public class MessageTextProvider {

    private final static String MESSAGE_FILE = "messages_test_ru.properties";

    private MessageTextProvider() {
    }

    public static String get(String key) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(MESSAGE_FILE);
        return resourceBundle.getString(key);
    }


}
