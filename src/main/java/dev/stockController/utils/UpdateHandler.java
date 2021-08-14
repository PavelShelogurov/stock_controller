package dev.stockController.utils;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class UpdateHandler {

    public SendMessage processMessage(Update update) {
        Message message = update.getMessage();
        return new SendMessage(message.getChatId().toString(), message.getText() + message.getAuthorSignature());
    }
}
