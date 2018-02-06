package coinpurse;

/**
 * BankNote represents banknote(money) with a fixed value, currency, and unique serial number.
 * @author Gunthee tawewatmongkol
 */
public class BankNote {
	
	private static long nextSerialNumber = 1000000L;
	private double value;
	private String currency;
	private long serialNumber;
	
	/**
	 * Create a banknote with value and currency.
	 * @param value is value of a banknote.
	 * @param currency is currency of a banknote.
	 */
	public BankNote(double value, String currency) {
		this.value = value;
		this.currency = currency;
		this.serialNumber = nextSerialNumber;
		nextSerialNumber ++;
	}

	/**
	 * Get the total value of a banknote.
	 * @return the total value of a banknote.
	 */
	public double getValue() {
		return value;
	}

	/**
	 * Get the currency of a banknote.
	 * @return the currency of a banknote.
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * Get the serial number of a banknote.
	 * @return the serial number of a banknote.
	 */
	public long getSerialNumber() {
		return serialNumber;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null) return false;
		if(obj.getClass() != this.getClass()) return false;
		BankNote other = (BankNote)obj;
		return ((other.getCurrency().equals(this.getCurrency()))&&(other.getValue() == this.getValue()));
	}
	
	@Override
	public String toString() {
		return String.format("%.2f-%s note [%l]", this.value, this.currency, this.serialNumber);
	}
	
}
