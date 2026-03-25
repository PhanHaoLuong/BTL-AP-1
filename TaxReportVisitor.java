public class TaxReportVisitor implements InstrumentVisitor {
	public double totalTaxLiability = 0;

	@Override
	public void visit(Bond bond) {
		this.totalTaxLiability += bond.annualCouponPayment(1) * 0.3;
	}

	@Override
	public void visit(Stock stock) {
		this.totalTaxLiability += stock.getCurrentPriceValue() * 0.15;
	}

	@Override
	public void visit(Future future) {
		this.totalTaxLiability += future.getCurrentPriceValue() * 0.2;
	}

	@Override
	public void visit(Option option) {
		this.totalTaxLiability += option.getCurrentPriceValue() * 0.2;
	}

	public double getTotalTaxLiability() {
		return this.totalTaxLiability;
	}

	public String getReport() {
		return String.format("TAX: %s", this.totalTaxLiability);
	}
}
