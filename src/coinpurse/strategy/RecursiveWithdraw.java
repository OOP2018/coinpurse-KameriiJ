package coinpurse.strategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import coinpurse.Valuable;
import coinpurse.ValueComparator;

public class RecursiveWithdraw implements WithdrawStrategy{
	
	public static List<Valuable> helper(List<Valuable> list, List<Valuable> templist, double target, String currency) {
		Valuable check;
		try { check = list.get(0); } catch (Exception ex) { return null; }
		double result = target;
		if(check.getCurrency().equalsIgnoreCase(currency)) {
			result = target - check.getValue();
			if(result >= 0) {
				templist.add(check);
			}
			if(result < 0) result = target;
		}
		if (list.size() > 1) helper(list.subList(1, list.size()), templist, result, currency);
		if (list.size() <= 1 && result != 0) return null;
		return templist;
	}

	@Override
	public List<Valuable> withdraw(Valuable amount, List<Valuable> money) {
		List<Valuable> templist = new ArrayList<Valuable>(money.size());
		if(amount == null || amount.getValue() == 0) return templist;
		
		Comparator<Valuable> comp = new ValueComparator();
		java.util.Collections.sort(money, comp);
		java.util.Collections.reverse(money);
		
		double target = amount.getValue();
		
		return helper(money, templist, target, amount.getCurrency());
	}
	
}
