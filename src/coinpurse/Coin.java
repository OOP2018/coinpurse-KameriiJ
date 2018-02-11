package coinpurse;

/**
 * Coin represents coinage (money) with a fixed value and currency.
 * @author Gunthee tawewatmongkol
 */
public class Coin extends Money {
	/**
	 * Create a coin with value and currency.
	 * @param value is value of a coin.
	 * @param currency is currency of a coin.
	 */
	public Coin(double value, String currency) {
		super(value, currency);
	}
	
	@Override
	public String toString() {
		return String.format("%.2f-%s", this.getValue(), this.getCurrency());
	}
	
}
