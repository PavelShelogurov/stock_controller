package dev.stockController.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

@Component
public class View {

    public static final String SHOW_ALL_STOCKS = "Показать доступные акции";
    public static final String SET_NOTICE = "Установить слежку";
    public static final String SHOW_MY_PARAMETERS = "Текущии настройки";
    public static final String MAIN_MENU_TEXT = "Веберите действие";

    @Value("${limit.length.text.message}")
    private int maxTextMessageLength;


    public List<SendMessage> showMenu(String chatId) {
        List<SendMessage> menuMessageList = new ArrayList<>();
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.enableMarkdown(true);
        sendMessage.setText(MAIN_MENU_TEXT);
        sendMessage.setReplyMarkup(getMenuKeyboard());
        menuMessageList.add(sendMessage);
        return menuMessageList;
    }

    private ReplyKeyboardMarkup getMenuKeyboard() {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        keyboardMarkup.setSelective(true);
        keyboardMarkup.setResizeKeyboard(true);
        keyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row1 = new KeyboardRow();
        row1.add(new KeyboardButton(SHOW_ALL_STOCKS));
        KeyboardRow row2 = new KeyboardRow();
        row2.add(new KeyboardButton(SET_NOTICE));
        KeyboardRow row3 = new KeyboardRow();
        row3.add(new KeyboardButton(SHOW_MY_PARAMETERS));
        keyboardRows.add(row1);
        keyboardRows.add(row2);
        keyboardRows.add(row3);
        keyboardMarkup.setKeyboard(keyboardRows);
        return keyboardMarkup;
    }

    public List<SendMessage> sendTextMessage(String chatId, String text) {
        List<SendMessage> messageList = new LinkedList<>();
        int processedSymbols = 0;
        while (processedSymbols < text.length()){
            int endOfNextTextMessage = Math.min(processedSymbols + maxTextMessageLength, text.length());
            messageList.add(new SendMessage(chatId, text.substring(processedSymbols, endOfNextTextMessage)));
            processedSymbols = endOfNextTextMessage;
        }
        return messageList;
    }

}
