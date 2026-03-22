public interface PricingStrategy {
	public abstract double calculateFairValue(Instrument instrument);

	public abstract String strategyName();
}
