public class Option extends Derivative {
    private final double strikePrice;
    private final boolean isCall;
    private final int expiryDays;

    public Option(String symbol, String name, double currentPrice, double strikePrice, boolean isCall, int expiryDays) {
        super(symbol, name, currentPrice);
        // TODO
        // throw new UnsupportedOperationException("TODO");
        this.strikePrice = strikePrice;
        this.isCall = isCall;
        this.expiryDays = expiryDays;
    }

    @Override
    public double riskScore() {
        // TODO
        // throw new UnsupportedOperationException("TODO");
        return 8.5;
    }
    
    public boolean isInTheMoney(double spotPrice) {
        // TODO
        // throw new UnsupportedOperationException("TODO");
        if (isCall) return (spotPrice > this.strikePrice);
        else return (spotPrice < this.strikePrice);
    }

    public double getStrikePrice() {
        // TODO
        // throw new UnsupportedOperationException("TODO");
        return this.strikePrice;
    }

    public boolean isCall() {
        // TODO
        // throw new UnsupportedOperationException("TODO");
        return this.isCall;
    }

    public int getExpiryDays() {
        // TODO
        // throw new UnsupportedOperationException("TODO");
        return this.expiryDays;
    }
}
