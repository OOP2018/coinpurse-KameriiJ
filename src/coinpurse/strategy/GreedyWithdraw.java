package coinpurse.strategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import coinpurse.Valuable;
import coinpurse.ValueComparator;

public class GreedyWithdraw implements WithdrawStrategy{

	@Override
	public List<Valuable> withdraw(Valuable amount, List<Valuable> money) {
		List<Valuable> templist = new ArrayList<Valuable>(money.size());
		Comparator<Valuable> comp = new ValueComparator();
		java.util.Collections.sort(money, comp);
		
		return null;
	}
	
}
