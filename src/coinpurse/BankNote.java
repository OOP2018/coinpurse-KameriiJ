package coinpurse;

/**
 * BankNote represents banknote(money) with a fixed value, currency, and unique serial number.
 * 
 * @author Gunthee tawewatmongkol
 */
public class BankNote extends Money {
	private static long nextSerialNumber = 1000000L;
	private long serialNumber;
	
	/**
	 * Create a banknote with value, currency, and serialnumber.
	 * @param value is value of a banknote.
	 * @param currency is currency of a banknote.
	 */
	public BankNote(double value, String currency, long nextSerialNumber) {
		super(value, currency);
		this.serialNumber = nextSerialNumber;
		nextSerialNumber++;
	}
	
	/**
	 * Create a banknote with value, currency, and serialnumber
	 * without using MoneyFactory's serialnumber(for PurseTest, MoneyUtil, 
	 * and comparing money objects in MoneyFactoryTest).
	 * @param value is value of a banknote.
	 * @param currency is currency of a banknote.
	 */
	public BankNote(double value, String currency) {
		super(value, currency);
		this.serialNumber = nextSerialNumber;
		nextSerialNumber++;
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
