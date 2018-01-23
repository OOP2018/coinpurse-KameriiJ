package coinpurse;

/**
 * Coin represents coinage (money) with a fixed value and currency.
 * @author Gunthee tawewatmongkol
 */
public class Coin implements Comparable<Coin>{
	private double value;
	private String currency;
	
	/**
	 * Create a coin with value and currency.
	 * @param value is value of a coin.
	 * @param currency is currency of a coin.
	 */
	public Coin(double value, String currency) {
		this.value = value;
		this.currency = currency;
	}
	
	/**
	 * Get the total value of a coin.
	 * @return the total value of a coin.
	 */
	public double getValue() {
		return this.value;
	}
	
	/**
	 * Get the currency of a coin.
	 * @return the currency of a coin.
	 */
	public String getCurrency() {
		return this.currency;
	}
	
	@Override
	public boolean equals(Object arg) {
		if(this == arg) return true;
		if(arg == null) return false;
		if(arg.getClass() != this.getClass()) return false;
		Coin other = (Coin)arg;
		return ((other.getCurrency().equals(this.getCurrency()))&&(other.getValue() == this.getValue()));
	}
	
	/**
	 * Order value of coins in the list.(smaller to bigger)
	 * @param coin
	 **/
	public int compareTo(Coin coin) {
		if (this.getValue() > coin.getValue()) return 1;
		else if (this.getValue() < coin.getValue()) return -1;
		return 0;
	}
	
	@Override
	public String toString() {
		return String.format("%.2f-%s", this.value, this.currency);
	}
	
}
