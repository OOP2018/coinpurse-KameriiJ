package coinpurse.strategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import coinpurse.Valuable;
import coinpurse.ValueComparator;

public class GreedyWithdraw implements WithdrawStrategy{
	
	/**
	 * Get the total value of all items in the list
	 * @return the total value of items in the list.
	 */
	public double getBalance(List<Valuable> money) {
		double totalValue = 0;
		for (Valuable x : money) {
			totalValue += x.getValue();
		}
		return totalValue;
	}
	
	/**
	 * Withdraw the requested amount of money. Return a new temporarylist of Valuable items withdrawn
	 * from list, or return null if cannot withdraw the amount requested.
	 * Using only items that have the same currency as the parameter.
	 * 
	 * @param amount is the object of amount to withdraw
	 * @param money is the list that represent purse.
	 * @return array of Valuable objects for money withdrawn, or null if cannot withdraw
	 *         requested amount.
	 */
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
