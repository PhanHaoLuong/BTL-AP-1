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

		throw new PositionNotFoundException(String.format("Position not found: %s", symbol));
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

		throw new PositionNotFoundException(String.format("Position not found: %s", symbol));
	}

	public List<Position> getPositionsSortedByValue() {
		// TODO
		// throw new UnsupportedOperationException("TODO");
		List<Position> sPositions = new ArrayList<>(positions);
		sPositions.sort((Position a, Position b) -> Double.compare(b.marketValue(), a.marketValue()));
		return sPositions;
	}

	public Map<String, Double> allocationByAssetClass() {
		// TODO
		// throw new UnsupportedOperationException("TODO");
		double totalValue = 0.0;
		for (Position p : this.positions) {
			totalValue += p.getInstrument().getCurrentPriceValue();
		}

		Map<String, Double> allocation = new HashMap<>();
		if (totalValue == 0.0)
			return allocation;
		for (Position p : this.positions) {
			String asset = p.getInstrument().assetClass();
			double currentValue = allocation.getOrDefault(asset, 0.0);
			allocation.put(asset, currentValue + p.getInstrument().getCurrentPriceValue());
		}

		for (Map.Entry<String, Double> e : allocation.entrySet()) {
			double percentage = (e.getValue() / totalValue) * 100;
			allocation.put(e.getKey(), percentage);
		}

		return allocation;
	}

	public void revalueAll(PricingStrategy strategy) {
		// TODO
		// throw new UnsupportedOperationException("TODO");
		for (Position p : this.positions) {
			Instrument i = p.getInstrument();
			i.updatePrice(strategy.calculateFairValue(i));
		}
		notifyObservers(String.format("REVALUED: %s", strategy.strategyName()));
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
