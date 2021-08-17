package dev.stockController.service;


import dev.stockController.model.StocksList;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.*;

@Service
public class APIProcessor {
    @Value("${url.stocks.list}")
    private String urlStocksList;
    @Value("${tinkoff.openapi.production.token}")
    private String tokenProduction;

    public StocksList findAllStocks() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(tokenProduction);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> httpEntity = new HttpEntity<>(headers);

        ResponseEntity<StocksList> response = restTemplate.exchange(urlStocksList, HttpMethod.GET, httpEntity, StocksList.class);
        return response.getBody();
    }

}
