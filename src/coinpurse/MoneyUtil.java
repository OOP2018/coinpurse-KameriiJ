package coinpurse;

import java.util.ArrayList;
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
	 * @param coins
	 */
	public static void sortCoins(List<Coin> coins) {
		java.util.Collections.sort(coins);
	}
	
	/**
	 * Build new List that contains only the coins from coins 
	 * that have same currency as the currency parameter.
	 * 
	 * @param coins
	 * @param currency
	 * @return a list of Coins that contains only the coins from coins 
	 * 		   that have same currency as the currency parameter
	 */
	public static List<Coin> filterByCurrency(List<Coin> coins, String currency){
		List<Coin> sameCurrencyList = new ArrayList<Coin>(coins.size());
		for(Coin x : coins) {
			if(x.getCurrency().toLowerCase().equals(currency.toLowerCase())) {
				sameCurrencyList.add(x);
			}
		}
		return sameCurrencyList;
	}
	
	/**
	 * Print all coins in the list.
	 * @param coins
	 */
	public static void printCoins(List<Coin> coins) {
		for(int x = 0;x < coins.size();x++) {
			System.out.println(coins.get(x));
		}
	}
	
	public static void main(String[]args) {
		List<Coin> coins = new ArrayList<Coin>();
		coins.add(new Coin(10, "Bath"));
		coins.add(new Coin(200, "Coins"));
		coins.add(new Coin(30, "Rupie"));
		coins.add(new Coin(10, "Dollars"));
		coins.add(new Coin(0.5, "Dollars"));
		coins.add(new Coin(1, "Dollars"));
		coins.add(new Coin(2, "Dollars"));
		
		System.out.println("List of coins:");
		printCoins(coins);
		System.out.println("\nSort coins:");
		sortCoins(coins);
		printCoins(coins);
		
		System.out.println("\nTest filterByCurrency(): ");
		List<Coin> testFilterCurrency = filterByCurrency(coins, "Dollars");
		printCoins(testFilterCurrency);
	}
}
