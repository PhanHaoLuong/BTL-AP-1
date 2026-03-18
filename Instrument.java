import java.time.LocalDateTime;

public abstract class Instrument {
    private final String symbol;
    private String name;
    private double currentPrice;
    private LocalDateTime lastUpdated;

    public Instrument(String symbol, String name, double currentPrice) {
        // TODO
        // throw new UnsupportedOperationException("TODO");
        this.symbol = symbol;
        this.name = name;
        this.currentPrice = currentPrice;
    }

    public abstract double riskScore();

    public abstract String assetClass();
    
    public void updatePrice(double newPrice) {
        // TODO
        // throw new UnsupportedOperationException("TODO");
        if (newPrice < 0) throw new IllegalArgumentException();
    }

    public String getSymbol() {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public String getName() {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public double getCurrentPriceValue() {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public LocalDateTime getLastUpdated() {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public String toString() {
        // TODO
        // throw new UnsupportedOperationException("TODO");
        return this.toString();
    }
}
