public class Position {
	private final Instrument instrument;
	private int quantity;
	private double averageCostBasis;

	public Position(Instrument instrument, int quantity, double averageCostBasis) {
		// TODO
		// throw new UnsupportedOperationException("TODO");
		this.instrument = instrument;
		this.quantity = quantity;
		this.averageCostBasis = averageCostBasis;
	}

	public double marketValue() {
		// TODO
		// throw new UnsupportedOperationException("TODO");
		return this.quantity * this.instrument.getCurrentPriceValue();
	}

	public double unrealizedPnL() {
		// TODO
		// throw new UnsupportedOperationException("TODO");
		return this.marketValue() - this.quantity * this.averageCostBasis;
	}

	public void addQuantity(int qty, double costBasis) {
		// TODO
		throw new UnsupportedOperationException("TODO");
	}

	public Instrument getInstrument() {
		// TODO
		// throw new UnsupportedOperationException("TODO");
		return this.instrument;
	}

	public int getQuantity() {
		// TODO
		// throw new UnsupportedOperationException("TODO");
		return this.quantity;
	}

	public double getAverageCostBasis() {
		// TODO
		// throw new UnsupportedOperationException("TODO");
		return this.averageCostBasis;
	}

	@Override
	public String toString() {
		// TODO
		// throw new UnsupportedOperationException("TODO");
		return String.format(
				"Position[symbol=%s, qty=%s, value=%.2f, pnl=%.2f",
				this.getInstrument().getSymbol(),
				this.quantity,
				this.marketValue(),
				this.unrealizedPnL());
	}
}
