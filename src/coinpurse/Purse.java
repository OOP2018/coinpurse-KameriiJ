package coinpurse;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * A coin purse contains coins. You can insert coins, withdraw money, check the
 * balance, and check if the purse is full.
 * 
 * @author Gunthee Taweatmongkol
 */
public class Purse {
	/** Collection of objects in the purse. */
	private List<Valuable> money;

	/**
	 * Capacity is maximum number of items the purse can hold. Capacity is set when
	 * the purse is created and cannot be changed.
	 */
	private final int capacity;

	/**
	 * Create a purse with a specified capacity.
	 * 
	 * @param capacity
	 *            is maximum number of coins you can put in purse.
	 */
	public Purse(int capacity) {
		this.capacity = capacity;
		this.money = new ArrayList<Valuable>(this.capacity);
	}

	/**
	 * Count and return the number of coins in the purse. This is the number of
	 * coins, not their value.
	 * 
	 * @return the number of coins in the purse
	 */
	public int count() {
		return this.money.size();
	}

	/**
	 * Get the total value of all items in the purse.
	 * 
	 * @return the total value of items in the purse.
	 */
	public double getBalance() {
		double totalValue = 0;
		for (Valuable x : money) {
			totalValue += x.getValue();
		}
		return totalValue;
	}

	/**
	 * Return the capacity of the coin purse.
	 * 
	 * @return the capacity
	 */
	public int getCapacity() {
		return this.capacity;
	}

	/**
	 * Test whether the purse is full. The purse is full if number of items in purse
	 * equals or greater than the purse capacity.
	 * 
	 * @return true if purse is full.
	 */
	public boolean isFull() {
		return this.money.size() >= this.capacity;
	}

	/**
	 * Insert a coin into the purse. The coin is only inserted if the purse has
	 * space for it and the coin has positive value. No worthless coins!
	 * 
	 * @param coin
	 *            is a Coin object to insert into purse
	 * @return true if coin inserted, false if can't insert
	 */
	public boolean insert(Valuable coin) {
		if ((isFull()) || (coin.getValue() <= 0)) return false;
		money.add(coin);
		return true;
	}

	/**
	 * Withdraw the requested amount of money. Return an array of Coins withdrawn
	 * from purse, or return null if cannot withdraw the amount requested.
	 * 
	 * @param amount
	 *            is the amount to withdraw
	 * @return array of Coin objects for money withdrawn, or null if cannot withdraw
	 *         requested amount.
	 */
	public Valuable[] withdraw(double amount) {
		List<Valuable> templist = new ArrayList<Valuable>(this.money.size());
		double amountNeededToWithdraw = amount;
		Valuable[] withdraw = null;
		Comparator<Valuable> comp = new ValueComparator();
		java.util.Collections.sort(this.money, comp);

		if ((amount <= 0) || (this.getBalance() < amount)) {
			return null;
		} else {
			for (int x = (this.money.size() - 1); x >= 0; x--) {
				double coinValue = this.money.get(x).getValue();
				if ((amountNeededToWithdraw - coinValue) >= 0) {
					amountNeededToWithdraw -= coinValue;
					templist.add((Valuable) this.money.get(x));
				}
				if (amountNeededToWithdraw == 0) {
					withdraw = new Coin[templist.size()];
					templist.toArray(withdraw);
					for (Valuable j : templist) {
						this.money.remove(j);
					}
					break;
				}
			}
		}

		/*
		 * See lab sheet for outline of a solution, or devise your own solution. The
		 * idea is to be greedy. Try to withdraw the largest coins possible. Each time
		 * you choose a coin as a candidate for withdraw, add it to a temporary list and
		 * decrease the amount (remainder) to withdraw.
		 * 
		 * If you reach a point where amountNeededToWithdraw == 0 then you found a
		 * solution! Now, use the temporary list to remove coins from the money list,
		 * and return the temporary list (as an array).
		 */

		// Did we get the full amount?
		// This code assumes you decrease amount each time you remove a coin.
		// Your code might use some other variable for the remaining amount to withdraw.
		if (amountNeededToWithdraw != 0) {
			return null;
		}

		// Success.
		// Remove the coins you want to withdraw from purse,
		// and return them as an array.
		// Use list.toArray( array[] ) to copy a list into an array.
		// toArray returns a reference to the array itself.
		return withdraw;
	}

	/**
	 * toString returns a string description of the purse contents. It can return
	 * whatever is a useful description.
	 */
	@Override
	public String toString() {
		String c = "coins";
		if (this.money.size() == 1)
			c = "coin";
		return String.format("%d %s with value %.1f", this.count(), c, this.getBalance());
	}

}
