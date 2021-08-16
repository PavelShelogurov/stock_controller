package dev.stockController.model;

public class Instruments {
    public String figi;
    public String ticker;
    public String isin;
    public String minPriceIncrement;
    public String lot;
    public String currency;
    public String name;
    public String type;

    public String getFigi() {
        return figi;
    }

    public void setFigi(String figi) {
        this.figi = figi;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public String getMinPriceIncrement() {
        return minPriceIncrement;
    }

    public void setMinPriceIncrement(String minPriceIncrement) {
        this.minPriceIncrement = minPriceIncrement;
    }

    public String getLot() {
        return lot;
    }

    public void setLot(String lot) {
        this.lot = lot;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
