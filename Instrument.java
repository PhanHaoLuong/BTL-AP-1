import java.awt.List;
import java.time.LocalDateTime;

public abstract class Instrument implements Tradeable, Priceable {
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
		if (newPrice < 0)
			throw new IllegalArgumentException();
		else {
			this.currentPrice = newPrice;
		}
	}

	public String getSymbol() {
		// TODO
		// throw new UnsupportedOperationException("TODO");
		return this.symbol;
	}

	public String getName() {
		// TODO
		// throw new UnsupportedOperationException("TODO");
		return this.name;
	}

	public double getCurrentPriceValue() {
		// TODO
		// throw new UnsupportedOperationException("TODO");
		return this.currentPrice;
	}

	public LocalDateTime getLastUpdated() {
		// TODO
		// throw new UnsupportedOperationException("TODO");
		return this.lastUpdated;
	}

	@Override
	public String toString() {
		// TODO
		// throw new UnsupportedOperationException("TODO");
		return String.format(
				"%s[symbol=%s, price=%.2f, risk=%.1f]",
				this.getClass().getSimpleName(),
				this.getSymbol(),
				this.getCurrentPriceValue(),
				this.riskScore());
	}

	@Override
	public double getPriceChange(double previousPrice) {
		return this.currentPrice - previousPrice;
	}

	@Override
	public double getPriceChangePercent(double previousPrice) {
		return (this.getPriceChange(previousPrice) / previousPrice) * 100;
	}

	@Override
	public boolean isAvailableForTrading() {
		return true;
	}

	public abstract void accept(InstrumentVisitor instrumentVisitor);
}
