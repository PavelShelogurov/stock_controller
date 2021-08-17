package dev.stockController.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Instrument implements Comparable<Instrument>{
    public String figi;
    public String ticker;
    public String isin;
    public String minPriceIncrement;
    public String lot;
    public String currency;
    public String name;
    public String type;


    @Override
    public int compareTo(Instrument o) {
        return name.compareTo(o.name);
    }
}
