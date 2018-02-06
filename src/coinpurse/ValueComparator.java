package coinpurse;

import java.util.Comparator;

public class ValueComparator implements Comparator<Valuable> {

	/**
     * Compare two objects that implement Valuable.
     * If both objects have the same currency, order them by value.
     */
	@Override
	public int compare(Valuable a, Valuable b) {
		if(a.getCurrency().equals(b.getCurrency())){
			if (a.getValue() > b.getValue()) return 1;
			else if (a.getValue() < b.getValue()) return -1;
		}
		return 0;
	}
	
}
