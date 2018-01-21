package coinpurse;

import java.util.ArrayList;
import java.util.List;

public class MoneyUtil {
	
	public static void sortCoins(List<Coin> coins) {
		java.util.Collections.sort(coins);
	}
	
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
