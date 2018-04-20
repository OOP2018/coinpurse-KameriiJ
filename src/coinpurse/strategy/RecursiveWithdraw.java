package coinpurse.strategy;

import java.util.*;

import coinpurse.Money;
import coinpurse.Valuable;
import coinpurse.ValueComparator;

public class RecursiveWithdraw implements WithdrawStrategy{
	
	@Override
	public List<Valuable> withdraw(Valuable amount, List<Valuable> money) {
		List<Valuable> templist = new ArrayList<Valuable>(money.size());
		Comparator<Valuable> comp = new ValueComparator();
		Collections.sort(money, comp);
		Collections.reverse(money);
		return helper(money, templist, amount);
	}
	
	public static List<Valuable> helper(List<Valuable> list, List<Valuable> templist, Valuable amount) {
		Valuable check; double target; String currency;
		try { 
			check = list.get(0); target = amount.getValue(); currency = amount.getCurrency();
		} catch (Exception ex) {
			return null; 
		}
		double result = target;
		if(check.getCurrency().equalsIgnoreCase(currency)) {
			result -= check.getValue();
			if(result >= 0) {
				templist.add(check);
			}
			if(result < 0) result = target;
		}
		if (list.size() > 1) helper(list.subList(1, list.size()), templist, new Money(result, currency));
		if (list.size() < 2 && result != 0) templist.clear();
		return (templist.size() != 0) ? templist : null;
	}
}
