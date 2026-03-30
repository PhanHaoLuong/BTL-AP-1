import java.util.*;

public class RiskAnalyzer<T extends Instrument> {
	private final List<T> instruments = new ArrayList<>();
	private double totalRisk = 0;
	private int count = 0;
	private T highestR = null;
	private T lowestR = null;

	public void add(T instrument) {
		// TODO
		// throw new UnsupportedOperationException("TODO");
		this.instruments.add(instrument);
		totalRisk += instrument.riskScore();
		count++;

		if (highestR == null)
			highestR = instrument;
		else {
			if (highestR.riskScore() < instrument.riskScore())
				highestR = instrument;
		}

		if (lowestR == null)
			lowestR = instrument;
		else {
			if (lowestR.riskScore() > instrument.riskScore())
				lowestR = instrument;
		}
	}

	public double averageRisk() {
		// TODO
		// throw new UnsupportedOperationException("TODO");
		return count == 0 ? 0 : totalRisk / count;
	}

	public T highestRisk() {
		// TODO
		// throw new UnsupportedOperationException("TODO");
		return highestR;
	}

	public T lowestRisk() {
		// TODO
		// throw new UnsupportedOperationException("TODO");
		return lowestR;
	}

	public List<T> getAboveRiskThreshold(double threshold) {
		// TODO
		// throw new UnsupportedOperationException("TODO");
		List<T> rL = new ArrayList<>();
		for (T i : instruments) {
			if (i.riskScore() > threshold)
				rL.add(i);
		}

		return rL;
	}
}
