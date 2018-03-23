package coinpurse.strategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import coinpurse.Valuable;
import coinpurse.ValueComparator;

public class GreedyWithdraw implements WithdrawStrategy{
	
	public double getBalance(List<Valuable> money) {
		double totalValue = 0;
		for (Valuable x : money) {
			totalValue += x.getValue();
		}
		return totalValue;
	}
	
	@Override
	public List<Valuable> withdraw(Valuable amount, List<Valuable> money) {
		List<Valuable> templist = new ArrayList<Valuable>(money.size());
		
		if ((amount == null) || (amount.getValue() == 0)) return templist;
		if ((amount.getValue() < 0) || (getBalance(money) < amount.getValue())) return null;
		
		Comparator<Valuable> comp = new ValueComparator();
		java.util.Collections.sort(money, comp);
		double amountNeededToWithdraw = amount.getValue();
		
		for (int x = (money.size() - 1); x >= 0; x--) {
			if(money.get(x).getCurrency().equalsIgnoreCase(amount.getCurrency())) {
				double value = money.get(x).getValue();
				if ((amountNeededToWithdraw - value) >= 0) {
					amountNeededToWithdraw -= value;
					templist.add(money.get(x));
				}
				if (amountNeededToWithdraw == 0) {
					return templist;
				}
			}
		}
		return null;
	}
}
