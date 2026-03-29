public interface Tradeable {
	String getSymbol();

	double getCurrentPriceValue();

	boolean isAvailableForTrading();

	default String getTradingInfo() {
		// TODO
		// throw new UnsupportedOperationException("TODO");
		return String.format(
				"Tradeable: %s @ %.2f [%s]",
				this.getSymbol(),
				this.getCurrentPriceValue(),
				(this.isAvailableForTrading() ? "AVAILABLE" : "UNAVAILABLE"));
	}
}
