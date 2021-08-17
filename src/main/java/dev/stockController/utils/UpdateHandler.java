package dev.stockController.utils;

import dev.stockController.service.StockDataProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

@Service
public class UpdateHandler {
    @Autowired
    private View view;
    @Autowired
    private StockDataProvider stockDataProvider;

    @Value("${error.in.developing}")
    private String inDeveloping;

    public List<SendMessage> processMessage(Update update) {

        Message message = update.getMessage();
        switch (message.getText()) {
            case View.SHOW_ALL_STOCKS:
                return view.sendTextMessage(message.getChatId().toString(), stockDataProvider.getAllStocksName());
            case View.SET_NOTICE:
                return view.sendTextMessage(message.getChatId().toString(), inDeveloping);
            case View.SHOW_MY_PARAMETERS:
                return view.sendTextMessage(message.getChatId().toString(), inDeveloping);
            default:
                return view.showMenu(message.getChatId().toString());
        }
    }


}
