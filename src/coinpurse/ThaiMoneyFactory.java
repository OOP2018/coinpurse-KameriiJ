package coinpurse;

import java.util.Arrays;

public class ThaiMoneyFactory extends MoneyFactory{
	
	private final String CURRENCY = "Baht";
	private final double[] money = {1,2,5,10,20,50,100,500,1000};

	@Override
	public Valuable createMoney(double value) {
		try{
			Arrays.asList(money).contains(value);
		}catch(IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
		}
		if(value >= 20) return new BankNote(value,CURRENCY);
		else if(value < 20) return new Coin(value, CURRENCY);
		return null;
	}
}
