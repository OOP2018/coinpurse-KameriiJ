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
	
	public static <E extends Comparable<? super E>> E max(E ... args ) {
		E maxVal = args[0];
		for(int x = 1; x < args.length; x++) {
			if(args[x].compareTo(maxVal) > 0) maxVal = args[x];
		}
		return maxVal;
	}
	
	/**
	 * Order value of coins in the list.(smaller to bigger)
	 * @param cash
	 */
	public static void sortMoney(List<? extends Valuable> cash) {
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
	public static <E extends Valuable> List<E> filterByCurrency(List<E> cash, String currency){
		List<E> sameCurrencyList = new ArrayList<E>(cash.size());
		for(E x : cash) {
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
	public static void printCoins(List<? extends Valuable> cash) {
		for(int x = 0;x < cash.size();x++) {
			System.out.println(cash.get(x));
		}
	}
	
	public static void main(String[]args) {
		List<Coin> cash = new ArrayList<Coin>();
		cash.add(new Coin(10, "Baht"));
//		cash.add(new BankNote(200, "Baht"));
		cash.add(new Coin(30, "Rupie"));
		cash.add(new Coin(10, "Dollars"));
		cash.add(new Coin(0.5, "Dollars"));
//		cash.add(new BankNote(20, "Baht"));
//		cash.add(new BankNote(100, "Baht"));
		
		List<BankNote> bankList = new ArrayList<BankNote>();
		bankList.add(new BankNote(200, "Baht"));
		bankList.add(new BankNote(500, "USD"));
		
		System.out.println("List of coins:");
		printCoins(cash);
		System.out.println("\nSort coins:");
		sortMoney(cash);
		printCoins(cash);
		
		System.out.println("\nTest filterByCurrency(): ");
		List<Coin> testFilterCurrency = filterByCurrency(cash, "Dollars");
		printCoins(testFilterCurrency);
		
//		Money a = new Coin(1, "Baht");
//		Money b = new Coin(2, "Baht");
//		Money c = new BankNote(20, "Baht");
//		
//		String max = max("banana","zebra","cat");
//		Money maxM = MoneyUtil.max(a,b,c);
//		System.out.println("string = " + max);
//		System.out.println("money = "+maxM.getValue());
	}
}
