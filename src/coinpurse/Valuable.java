package coinpurse;

/**
 * Interface for objects that have the value and currency. 
 * @author Gunthee tawewatmongkol
 */
public interface Valuable {
	
	/**
     * Get the monetary value of this object.
     * @return the value of this object
     */
	public double getValue();
	
	/**
     * Get the currency of this object.
     * @return the currency of this object
     */
	public String getCurrency();
	
}
