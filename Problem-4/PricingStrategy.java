public interface PricingStrategy {
	abstract double calculateFairValue(Instrument instrument);

	abstract String strategyName();
}
