package dev.stockController.repository.impl;

import dev.stockController.model.Instrument;
import dev.stockController.repository.InstrumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class InstrumentServiceImpl {

    @Autowired
    private InstrumentRepository instrumentRepository;

    public void saveAll(List<Instrument> stockList){
        instrumentRepository.saveAll(stockList);
    }

    public Instrument findStockByName(String name){
        Optional<Instrument> instrument = instrumentRepository.findByName(name);
        return instrument.orElseThrow();
    }

    public List<Instrument> findAll(){
        return instrumentRepository.findAll();
    }

}
