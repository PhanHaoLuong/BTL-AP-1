import java.util.*;

public class Portfolio implements Observable<String> {
	private final String portfolioId;
	private final String ownerName;
	private final List<Position> positions;
	private final List<Observer<String>> observers;

	public Portfolio(String portfolioId, String ownerName) {
		// TODO
		// throw new UnsupportedOperationException("TODO");
		this.portfolioId = portfolioId;
		this.ownerName = ownerName;
		this.positions = new ArrayList<>();
		this.observers = new ArrayList<>();
	}

	public void addPosition(Instrument inst, int qty, double costBasis) {
		// TODO
		// throw new UnsupportedOperationException("TODO");
		Position p = new Position(inst, qty, costBasis);
		this.positions.add(p);

		String noti = "ADDED: " + inst.getSymbol() + " x" + qty;
		this.notifyObservers(noti);
	}

	public void removePosition(String symbol) throws PositionNotFoundException {
		// TODO
		// throw new UnsupportedOperationException("TODO");
		for (Position p : this.positions) {
			if (p.getInstrument().getSymbol() == symbol)
				this.positions.remove(p);
			String noti = "REMOVED: " + symbol;
			this.notifyObservers(noti);
		}

		throw new PositionNotFoundException("");
	}

	public double totalMarketValue() {
		// TODO
		// throw new UnsupportedOperationException("TODO");
		double total = 0;

		for (Position p : this.positions) {
			total += p.marketValue();
		}

		return total;
	}

	public double totalUnrealizedPnL() {
		// TODO
		// throw new UnsupportedOperationException("TODO");
		double totalUn = 0;

		for (Position p : this.positions) {
			totalUn += p.unrealizedPnL();
		}

		return totalUn;
	}

	public Position getPosition(String symbol) throws PositionNotFoundException {
		// TODO
		// throw new UnsupportedOperationException("TODO");
		for (Position p : this.positions) {
			if (p.getInstrument().getSymbol() == symbol)
				return p;
		}

		throw new PositionNotFoundException("");
	}

	public List<Position> getPositionsSortedByValue() {
		// TODO
		throw new UnsupportedOperationException("TODO");
	}

	public Map<String, Double> allocationByAssetClass() {
		// TODO
		throw new UnsupportedOperationException("TODO");
	}

	public void revalueAll(PricingStrategy strategy) {
		// TODO
		throw new UnsupportedOperationException("TODO");
	}

	@Override
	public void addObserver(Observer<String> observer) {
		// TODO
		// throw new UnsupportedOperationException("TODO");
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer<String> observer) {
		// TODO
		// throw new UnsupportedOperationException("TODO");
		observers.remove(observer);
	}

	@Override
	public void notifyObservers(String event) {
		// TODO
		// throw new UnsupportedOperationException("TODO");
		for (Observer o : observers) {
			o.onEvent(event);
		}
	}

	public String getPortfolioId() {
		// TODO
		// throw new UnsupportedOperationException("TODO");
		return this.portfolioId;
	}

	public String getOwnerName() {
		// TODO
		// throw new UnsupportedOperationException("TODO");
		return this.ownerName;
	}
}
