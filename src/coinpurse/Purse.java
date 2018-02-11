package coinpurse;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * A coin purse contains Valuable items(coins or banknotes). You can insert Valuable item, withdraw money, check the
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
	 * @param capacity is maximum number of Valuable items you can put in purse.
	 */
	public Purse(int capacity) {
		this.capacity = capacity;
		this.money = new ArrayList<Valuable>(this.capacity);
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
		if ((isFull()) || (cash.getValue() <= 0)) return false;
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
					templist.add(this.money.get(x));
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
	 * Withdraw the requested amount of money. Return an array of Valuable items withdrawn
	 * from purse, or return null if cannot withdraw the amount requested.
	 * Using only items that have the same currency as the parameter.
	 * 
	 * @param amount is the object of amount to withdraw
	 * @return array of Valuable objects for money withdrawn, or null if cannot withdraw
	 *         requested amount.
	 */
	public Valuable[ ] withdraw(Valuable amount) {
		List<Valuable> templist = new ArrayList<Valuable>(this.money.size());
		double amountNeededToWithdraw = amount.getValue();
		Valuable[] withdraw = null;
		Comparator<Valuable> comp = new ValueComparator();
		java.util.Collections.sort(this.money, comp);
		
		if ((amount.getValue() <= 0) || (this.getBalance() < amount.getValue()) || amount == null) {
			return null;
		} else {
			for (int x = (this.money.size() - 1); x >= 0; x--) {
				if(this.money.get(x).getCurrency().equalsIgnoreCase(amount.getCurrency())) {
					double value = this.money.get(x).getValue();
					if ((amountNeededToWithdraw - value) >= 0) {
						amountNeededToWithdraw -= value;
						templist.add(this.money.get(x));
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
