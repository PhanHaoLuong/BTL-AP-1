public class Bond extends Instrument {
	private final double couponRate;
	private final int maturityYears;

	public Bond(String symbol, String name, double currentPrice, double couponRate, int maturityYears) {
		super(symbol, name, currentPrice);
		// TODO
		// throw new UnsupportedOperationException("TODO");
		this.couponRate = couponRate;
		this.maturityYears = maturityYears;
	}

	@Override
	public double riskScore() {
		// TODO
		// throw new UnsupportedOperationException("TODO");
		if (this.maturityYears > 10)
			return 4.0;
		else
			return 2.0;
	}

	@Override
	public String assetClass() {
		// TODO
		// throw new UnsupportedOperationException("TODO");
		return "FIXED_INCOME";
	}

	public double annualCouponPayment(int units) {
		// TODO
		// throw new UnsupportedOperationException("TODO");
		return units * (this.getCurrentPriceValue()) * this.couponRate / 100;
	}

	public double getCouponRate() {
		// TODO
		// throw new UnsupportedOperationException("TODO");
		return this.couponRate;
	}

	public int getMaturityYears() {
		// TODO
		// throw new UnsupportedOperationException("TODO");
		return this.maturityYears;
	}
}
