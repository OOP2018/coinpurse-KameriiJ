package coinpurse;

public class Money implements Valuable{

	protected double value;
	protected String currency;

	public Money(double value, String currency) {
		this.value = value;
		this.currency = currency;
	}

	/**
	 * Get the total value of money.
	 * @return the total value of money.
	 */
	public double getValue() {
		return this.value;
	}

	/**
	 * Get the currency of money.
	 * @return the currency of money.
	 */
	public String getCurrency() {
		return this.currency;
	}
	
	@Override
	public boolean equals(Object arg) {
		if(this == arg) return true;
		if(arg == null) return false;
		if(arg.getClass() != this.getClass()) return false;
		Money other = (Money)arg;
		return ((other.getCurrency().equals(this.getCurrency()))&&(other.getValue() == this.getValue()));
	}

	@Override
	public int compareTo(Valuable money) {
		if(!this.getCurrency().equals(money.getCurrency())) {
			String a = this.getCurrency().toLowerCase();
			String b = money.getCurrency().toLowerCase();
			return a.compareTo(b);
		}
		else {
			return Double.compare(this.getValue(), money.getValue());
		}
	}
}