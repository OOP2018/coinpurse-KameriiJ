package coinpurse;

import java.util.Comparator;

public class ValueComparator implements Comparator<Valuable> {

	/**
     * Compare two objects that implement Valuable.
     * If both objects have the same currency, order them by value.
     * If the currencies are different, order them by alphabetical ordering.
     */
	@Override
	public int compare(Valuable a, Valuable b) {
		String currentA = a.getCurrency().toLowerCase();
		String currentB = b.getCurrency().toLowerCase();
		if(!currentA.equals(currentB)) {
			return currentA.compareTo(currentB);
		}
		else {
			return Double.compare(a.getValue(), b.getValue());
		}
	}
	
}
