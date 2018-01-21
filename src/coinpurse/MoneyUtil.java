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
		
		printCoins(coins);
		System.out.println();
		sortCoins(coins);
		printCoins(coins);
	}
}
