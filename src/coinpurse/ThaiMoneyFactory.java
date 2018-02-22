package coinpurse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * MoneyFactory class for creating money in Thai currency.
 * 
 * @author tawewatmongkol
 */
public class ThaiMoneyFactory extends MoneyFactory{
	private final static String CURRENCY = "Baht";
	private final List<Double> money = 
			new ArrayList<>(Arrays.asList(1.0, 2.0, 5.0, 10.0, 20.0, 50.0, 100.0, 500.0, 1000.0));

	/**
	 * Create new money object in Thai currency.
	 * @param value is amount of money to create.
	 */
	@Override
	public Valuable createMoney(double value) throws IllegalArgumentException{
		if(!money.contains(value)) {
			throw new IllegalArgumentException(value + " cannot be Thai coin or banknote.");
		}
		if (value >= 20) return new BankNote(value,CURRENCY);
		else return new Coin(value, CURRENCY);
	}
	
	@Override
	public String getCurrency() {
		return CURRENCY;
	}
}
