package coinpurse;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Test the Coin.
 * MoneyUtil adds new coins that have different value or currency into the list,
 * and orders value of coins in the list.(smaller to bigger)  
 * 
 * @author  Gunthee Tawewatmongkol
 */
public class MoneyUtil {
	
	/**
	 * Order value of coins in the list.(smaller to bigger)
	 * @param cash
	 */
	public static void sortCoins(List<Valuable> cash) {
		Comparator<Valuable> comp = new ValueComparator();
		java.util.Collections.sort(cash, comp);
	}
	
	/**
	 * Build new List that contains only the coins from coins 
	 * that have same currency as the currency parameter.
	 * 
	 * @param cash
	 * @param currency
	 * @return a list of Coins that contains only the coins from coins 
	 * 		   that have same currency as the currency parameter
	 */
	public static List<Valuable> filterByCurrency(List<Valuable> cash, String currency){
		List<Valuable> sameCurrencyList = new ArrayList<Valuable>(cash.size());
		for(Valuable x : cash) {
			if(x.getCurrency().toLowerCase().equals(currency.toLowerCase())) {
				sameCurrencyList.add(x);
			}
		}
		return sameCurrencyList;
	}
	
	/**
	 * Print all coins in the list.
	 * @param cash
	 */
	public static void printCoins(List<Valuable> cash) {
		for(int x = 0;x < cash.size();x++) {
			System.out.println(cash.get(x));
		}
	}
	
	public static void main(String[]args) {
		List<Valuable> cash = new ArrayList<Valuable>();
		cash.add(new Coin(10, "Baht"));
		cash.add(new Coin(200, "Coins"));
		cash.add(new Coin(30, "Rupie"));
		cash.add(new Coin(10, "Dollars"));
		cash.add(new Coin(0.5, "Dollars"));
		cash.add(new BankNote(20, "Baht"));
		cash.add(new BankNote(100, "Baht"));
		
		System.out.println("List of coins:");
		printCoins(cash);
		System.out.println("\nSort coins:");
		sortCoins(cash);
		printCoins(cash);
		
		System.out.println("\nTest filterByCurrency(): ");
		List<Valuable> testFilterCurrency = filterByCurrency(cash, "Dollars");
		printCoins(testFilterCurrency);
	}
}
