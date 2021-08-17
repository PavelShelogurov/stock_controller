package dev.stockController.service;

import dev.stockController.model.Instrument;
import dev.stockController.model.StocksList;
import dev.stockController.repository.impl.InstrumentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;


@Component
public class StockDataProvider {
    @Autowired
    private APIProcessor apiProcessor;
    @Autowired
    private InstrumentServiceImpl instrumentService;

    public String getAllStocksName() {
        List<Instrument> instrumentList = instrumentService.findAll();
        if(instrumentList.size()==0){
            instrumentList = findAllInstrumentsAndSaveToDB();
        }
        return convertInstrumentListToString(instrumentList);
    }

    private String convertInstrumentListToString(List<Instrument> instrumentsList) {
        Collections.sort(instrumentsList);
        StringBuilder allStocks = new StringBuilder();
        for (Instrument instrument : instrumentsList) {
            allStocks.append(instrument.name);
            allStocks.append("\n");
        }
        return new String(allStocks);
    }

    private List<Instrument> findAllInstrumentsAndSaveToDB(){
        StocksList stocksList = apiProcessor.findAllStocks();
        instrumentService.saveAll(stocksList.payload.instruments);
        return stocksList.payload.instruments;
    }


}
