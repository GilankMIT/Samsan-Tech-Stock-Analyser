package samsan.tech.entity;

public class Stock {
    private StockProperty stockProperty;
    private Float closingPrice;
    private Float openingPrice;
    private Float highPrice;
    private Float lowPrice;

    public StockProperty getStockProperty() {
        return stockProperty;
    }

    public void setStockProperty(StockProperty stockProperty) {
        this.stockProperty = stockProperty;
    }

    public Float getClosingPrice() {
        return closingPrice;
    }

    public void setClosingPrice(Float closingPrice) {
        this.closingPrice = closingPrice;
    }

    public Float getOpeningPrice() {
        return openingPrice;
    }

    public void setOpeningPrice(Float openingPrice) {
        this.openingPrice = openingPrice;
    }

    public Float getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(Float highPrice) {
        this.highPrice = highPrice;
    }

    public Float getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(Float lowPrice) {
        this.lowPrice = lowPrice;
    }
}
