package dev.stockController.service;


import dev.stockController.repository.impl.InstrumentServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.NoSuchElementException;

@SpringBootTest
public class InstrumentsServiceImplTest {

    @Autowired
    InstrumentServiceImpl instrumentService;

    @Test
    void searchNonExistentInstrument() {
        Assertions.assertThrows(NoSuchElementException.class, () -> instrumentService.findStockByName("Non existent stock"));
    }

}
