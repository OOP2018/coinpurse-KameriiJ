package coinpurse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * MoneyFactory class for creating money in Malaysia currency.
 * 
 * @author Gunthee tawewatmongkol
 */
public class MalayMoneyFactory extends MoneyFactory{
	private static long nextSerialNumber = 1000000L;
	private final static String CURRENCY = "Ringgit";
	private final List<Double> money = 
			new ArrayList<>(Arrays.asList(0.05, 0.10, 0.20, 0.50, 1.0, 2.0, 5.0, 10.0, 20.0, 50.0, 100.0));
	
	/**
	 * Create new money object in Malaysia currency.
	 * @param value is amount of money to create.
	 */
	@Override
	public Valuable createMoney(double value) throws IllegalArgumentException{
		if(!money.contains(value)) {
			throw new IllegalArgumentException(value + " cannot be Malaysia coin or banknote.");
		}
		if (value >= 1) {
			nextSerialNumber++;
			return new BankNote(value, CURRENCY, nextSerialNumber);
		}
		else return new Coin(value, CURRENCY);
	}
	
	@Override
	public String getCurrency() {
		return CURRENCY;
	}
}
