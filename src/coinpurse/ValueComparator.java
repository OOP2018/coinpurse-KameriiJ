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
		if (!a.getCurrency().equals(b.getCurrency())){
			String currentA = a.getCurrency().toLowerCase();
			String currentB = b.getCurrency().toLowerCase();
			int length = Math.min(currentA.length(), currentB.length());
			
			for (int x = 0; x < length; x++) {
				int chaA = currentA.charAt(x);
				int chaB = currentB.charAt(x);
				
				if (chaA < chaB) return -1;
				else if (chaA > chaB) return 1;
			}
		}
		else {
			if (a.getValue() > b.getValue()) return 1;
			else if (a.getValue() < b.getValue()) return -1;
		}
		return 0;
	}
	
}
