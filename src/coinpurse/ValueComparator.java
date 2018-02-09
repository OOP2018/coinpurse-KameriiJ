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
			int chaA = 0,chaB = 0;
			for (int x = 0; x < length; x++) {
				chaA = currentA.charAt(x);
				chaB = currentB.charAt(x);
				if (chaA < chaB) return -1;
				else if (chaA > chaB) return 1;
			}
			if(chaA == chaB && currentA.length() != currentB.length()) {
				if (currentA.length() < currentB.length()) return -1;
				else return 1;
			}
		}
		else {
			if (a.getValue() > b.getValue()) return 1;
			else if (a.getValue() < b.getValue()) return -1;
		}
		return 0;
	}
	
}
