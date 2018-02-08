package coinpurse;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * A coin purse contains coins or banknotes. You can insert coins or banknotes, withdraw money, check the
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
	 *            is maximum number of coins and banknotes you can put in purse.
	 */
	public Purse(int capacity) {
		this.capacity = capacity;
		this.money = new ArrayList<Valuable>(this.capacity);
	}

	/**
	 * Count and return the number of coins and banknotes in the purse. 
	 * This is the number of coins and banknotes, not their value.
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
	 * Return the capacity of the purse.
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
	 * Insert a coin or banknote into the purse. The coin or banknote is only inserted if the purse has
	 * space for it and the coin or banknote has positive value. No worthless coins or banknotes!
	 * 
	 * @param cash is a Coin or BankNote object to insert into purse
	 * @return true if coin or bonknote inserted, false if can't insert
	 */
	public boolean insert(Valuable cash) {
		if ((isFull()) || (cash.getValue() <= 0)) return false;
		money.add(cash);
		return true;
	}

	/**
	 * Withdraw the requested amount of money. Return an array of Coins or/and Banknotes(Valuable) withdrawn
	 * from purse, or return null if cannot withdraw the amount requested.
	 * 
	 * @param amount is the amount to withdraw
	 * @return array of Valuable objects for money withdrawn, or null if cannot withdraw
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
				double value = this.money.get(x).getValue();
				if ((amountNeededToWithdraw - value) >= 0) {
					amountNeededToWithdraw -= value;
					templist.add((Valuable) this.money.get(x));
				}
				if (amountNeededToWithdraw == 0) {
					withdraw = new Valuable[templist.size()];
					templist.toArray(withdraw);
					for (Valuable j : templist) {
						this.money.remove(j);
					}
					break;
				}
			}
		}
		
		if (amountNeededToWithdraw != 0) {
			return null;
		}
		
		return withdraw;
	}

	/**
	 * toString returns a string description of the purse contents. It can return
	 * whatever is a useful description.
	 */
	@Override
	public String toString() {
		String c = "items";
		if (this.money.size() == 1) c = "item";
		return String.format("%d %s with value %.1f", this.count(), c, this.getBalance());
	}

}
