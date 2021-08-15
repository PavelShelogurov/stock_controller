package dev.stockController.utils;

import dev.stockController.service.APIworker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class UpdateHandler {
    @Autowired
    private APIworker apIworker;
    @Autowired
    private View view;

    @Value("${error.in.developing}")
    private String inDeveloping;

    public SendMessage processMessage(Update update) {

        Message message = update.getMessage();
        switch (message.getText()) {
            case View.SHOW_ALL_STOCKS:
                return view.sendTextMessage(message.getChatId().toString(), apIworker.findAllStocks());
            case View.SET_NOTICE:
                return view.sendTextMessage(message.getChatId().toString(), inDeveloping);
            case View.SHOW_MY_PARAMETERS:
                return view.sendTextMessage(message.getChatId().toString(), inDeveloping);
            default:
                return view.showMenu(message.getChatId().toString());
        }
    }


}
