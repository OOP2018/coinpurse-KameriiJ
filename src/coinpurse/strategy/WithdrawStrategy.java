package coinpurse.strategy;

import java.util.List;
import coinpurse.Valuable;

/**
 * 
 * 
 * @author Gunthee Tawewatmongkol
 *
 */
public interface WithdrawStrategy {
	
	/**
	 * Find and return items from a collection whose total value equals the requested amount.
	 * @param amount is the amount of money to withdraw, with currency.
	 * @param money the contents that are available for possible withdraw.
	 * 		  Must not be null, but may be an empty list.
	 * 		  This list is not modified.
	 * @return If a solution is found, return a List containing references from the money list
	 * 		   whose sum equals the amount.
	 * 		   If a solution is not found, return the empty list.  
	 */
	public List<Valuable> withdraw(Valuable amount, List<Valuable> money);
	
}
