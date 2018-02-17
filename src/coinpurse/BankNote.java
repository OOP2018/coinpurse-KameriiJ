package coinpurse;

/**
 * BankNote represents banknote(money) with a fixed value, currency, and unique serial number.
 * 
 * @author Gunthee tawewatmongkol
 */
public class BankNote extends Money {
	
	private static long nextSerialNumberT = 1000000L;
	private static long nextSerialNumberM = 1000000L;
	private long serialNumber;
	
	/**
	 * Create a banknote with value and currency.
	 * @param value is value of a banknote.
	 * @param currency is currency of a banknote.
	 */
	public BankNote(double value, String currency) {
		super(value, currency);
		if(this.getCurrency().equals("Baht")) {
			this.serialNumber = nextSerialNumberT;
			nextSerialNumberT++;
		}
		if(this.getCurrency().equals("Ringgit")) {
			this.serialNumber = nextSerialNumberM;
			nextSerialNumberM++;
		}
	}

	/**
	 * Get the serial number of a banknote.
	 * @return the serial number of a banknote.
	 */
	public long getSerial() {
		return serialNumber;
	}
	
	@Override
	public String toString() {
		return String.format("%.2f-%s note [%d]", this.getValue(), this.getCurrency(), this.getSerial());
	}
	
}
