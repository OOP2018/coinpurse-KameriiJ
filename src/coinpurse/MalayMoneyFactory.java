package coinpurse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MalayMoneyFactory extends MoneyFactory{
	private final String CURRENCY = "Ringgit";
	private final List<Double> money = 
			new ArrayList<>(Arrays.asList(0.05, 0.10, 0.20, 0.50, 1.0, 2.0, 5.0, 10.0, 20.0, 50.0, 100.0));
	
	@Override
	public Valuable createMoney(double value) throws IllegalArgumentException{
		if(!money.contains(value)) {
			System.out.println(value + " isn't Malaysia money.");
			throw new IllegalArgumentException("This value cannot be Malaysia coin or banknote.");
		}
		if (value >= 1) return new BankNote(value,CURRENCY);
		else return new Coin(value, CURRENCY);
	}
}
