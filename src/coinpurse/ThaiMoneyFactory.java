package coinpurse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThaiMoneyFactory extends MoneyFactory{
	private final String CURRENCY = "Baht";
	private final List<Double> money = 
			new ArrayList<>(Arrays.asList(1.0, 2.0, 5.0, 10.0, 20.0, 50.0, 100.0, 500.0, 1000.0));

	@Override
	public Valuable createMoney(double value) throws IllegalArgumentException{
		if(!money.contains(value)) {
			System.out.println(value + " isn't Thai money.");
			throw new IllegalArgumentException("This value cannot be Thai coin or banknote.");
		}
		if (value >= 20) return new BankNote(value,CURRENCY);
		else return new Coin(value, CURRENCY);
	}
}
