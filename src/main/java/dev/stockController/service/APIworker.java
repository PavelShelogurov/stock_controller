package dev.stockController.service;

import dev.stockController.model.Instruments;
import dev.stockController.model.StocksList;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.*;

@Service
public class APIworker {
    @Value("${url.stocks.list}")
    private String urlStocksList;
    @Value("${tinkoff.openapi.production.token}")
    private String tokenProduction;

    public String findAllStocks() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(tokenProduction);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> httpEntity = new HttpEntity<>(headers);

        ResponseEntity<StocksList> response = restTemplate.exchange(urlStocksList, HttpMethod.GET, httpEntity, StocksList.class);

        StringBuilder allStocks = new StringBuilder();
        StocksList stocksList = response.getBody();
        List<String> sortedStockName = sortStocks(stocksList);
        for (String stockName : sortedStockName) {
            allStocks.append(stockName);
            allStocks.append("\n");
        }
        return new String(allStocks);
    }

    private List<String> sortStocks(StocksList stocksList){
        List<String> stocksName = new ArrayList<>();
        for(Instruments stockInfo : stocksList.payload.instruments){
            stocksName.add(stockInfo.name);
        }
        Collections.sort(stocksName);
        return stocksName;
    }
}
