package coinpurse;

/**
 * MoneyFactory class for creating money.
 * 
 * @author Gunthee tawewatmongkol
 */
public abstract class MoneyFactory {
	private static MoneyFactory instance = null;
	
	protected MoneyFactory() {}
	
	/**
	 * Get an instance of MoneyFactory.
	 * @return an object of a subclass (such as ThaiMoneyFactor).
	 */
	public static MoneyFactory getInstance() {
		if(instance == null) instance = new ThaiMoneyFactory();
		return instance;
	}
	
	/**
	 * Create new money object in the local currency.
	 * @param value is amount of money to create.
	 */
	public abstract Valuable createMoney(double value) ;
	
	/**
	 * Converts parameter to a double and calls createMoney(double).
	 * @param value is amounts of money(accepts money value as a String).
	 * @return Money object that contain with the value and the currency.
	 */
	public Valuable createMoney(String value) {
		double valueDb = 0;
	    try {
	       valueDb = Double.parseDouble( value );
	    } catch (IllegalArgumentException ex) {
	        System.out.println(ex.getMessage());
	    } catch (NullPointerException ex) {
	    		System.out.println("There is no value.");
	    		throw new NullPointerException("The value is null.");
		}
	    return createMoney( valueDb );
	}
	
	/**
	 * Set the MoneyFactory object that is used.
	 * @param f is instance to create Money.
	 */
	public static void setFactory(MoneyFactory f) {
		instance = f;
	}
	
	public abstract String getCurrency() ;
}
