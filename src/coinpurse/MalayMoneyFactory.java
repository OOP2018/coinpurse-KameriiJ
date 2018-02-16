package coinpurse;

import java.util.Arrays;

public class MalayMoneyFactory extends MoneyFactory{
	
	private final double[] money = {0.05,0.10,0.20,0.50,1,2,5,10,20,50,100};
	
	@Override
	public Valuable createMoney(double value) {
		try{
			Arrays.asList(money).contains(value);
		}catch(IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
		}
		if(value >= 1) return new BankNote(value,"Ringgit");
		else if(value < 1) return new Coin(value*100, "Sen");
		return null;
	}
	
}
