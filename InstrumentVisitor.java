public interface InstrumentVisitor {
	public abstract void visit(Stock stock);

	public abstract void visit(Bond bond);

	public abstract void visit(Option option);

	public abstract void visit(Future future);
}
