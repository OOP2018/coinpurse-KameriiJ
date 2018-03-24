package coinpurse;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import coinpurse.strategy.GreedyWithdraw;
import coinpurse.strategy.WithdrawStrategy;

/**
 * A coin purse contains Valuable items(coins or banknotes). You can insert Valuable item, withdraw money, check the
 * balance, and check if the purse is full.
 * 
 * @author Gunthee Taweatmongkol
 */
public class Purse {
	/** Collection of objects in the purse. */
	private List<Valuable> money;
	private WithdrawStrategy strategy;

	/**
	 * Capacity is maximum number of items the purse can hold. Capacity is set when
	 * the purse is created and cannot be changed.
	 */
	private final int capacity;

	/**
	 * Create a purse with a specified capacity.
	 * 
	 * @param capacity is maximum number of Valuable items you can put in purse.
	 */
	public Purse(int capacity) {
		this.capacity = capacity;
		this.money = new ArrayList<Valuable>(this.capacity);
		setWithdrawStrategy();
	}

	/** Set WithdrawStrategy */
	public void setWithdrawStrategy() {
		strategy = new GreedyWithdraw();
	}

	/**
	 * Count and return the number of Valuable items in the purse. 
	 * This is the number of Valuable items, not their value.
	 * 
	 * @return the number of Valuable items in the purse
	 */
	public int count() {
		return this.money.size();
	}
	
	public List<Valuable> getMoney(){
		return this.money;
	}

	/**
	 * Get the total value of all items in the purse.
	 * 
	 * @return the total value of items in the purse.
	 */
	public double getBalance() {
		double totalValue = 0;
		for (Valuable x : this.money) {
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
	 * Insert a Valuable item into the purse. The Valuable item is only inserted if the purse has
	 * space for it and the Valuable item has positive value. No worthless Valuable item!
	 * 
	 * @param cash is a Valuable items object to insert into purse
	 * @return true if Valuable item inserted, false if can't insert
	 */
	public boolean insert(Valuable cash) {
		if ((isFull()) || (cash.getValue() <= 0) || cash == null) return false;
		money.add(cash);
		return true;
	}

	/**
	 * Withdraw the requested amount of money. Return an array of Valuable items withdrawn
	 * from purse, or return null if cannot withdraw the amount requested.
	 * 
	 * @param amount is the amount to withdraw
	 * @return array of Valuable objects for money withdrawn, or null if cannot withdraw
	 *         requested amount.
	 */
	public Valuable[] withdraw(double amount) {
		return withdraw(new Money(amount,"Baht"));
	}
	
	/**
	 * Withdraw the requested amount of money. Return an array of Valuable items withdrawn
	 * from purse, or return null if cannot withdraw the amount requested.
	 * Using only items that have the same currency as the parameter.
	 * 
	 * @param amount is the object of amount to withdraw
	 * @return array of Valuable objects for money withdrawn, or null if cannot withdraw
	 *         requested amount.
	 */
	public Valuable[ ] withdraw(Valuable amount) {
		Valuable[] withdraw = null;
		List<Valuable> templist = strategy.withdraw(amount, this.money);
		if (templist == null) return null;
		withdraw = new Valuable[templist.size()];
		templist.toArray(withdraw);
		for (Valuable j : templist) {
			this.money.remove(j);
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
