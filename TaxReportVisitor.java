public class TaxReportVisitor implements InstrumentVisitor {
	public double totalTaxLiability = 0;

	@Override
	public void visit(Bond bond) {

	}

	@Override
	public void visit(Stock stock) {

	}

	@Override
	public void visit(Future future) {

	}

	@Override
	public void visit(Option option) {

	}
}
