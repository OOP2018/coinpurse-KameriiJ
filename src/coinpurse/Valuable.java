package coinpurse;

/**
 * Interface for objects that have the value and currency.
 *  
 * @author Gunthee tawewatmongkol
 */
public interface Valuable extends Comparable<Valuable>{
	
	/**
     * Get the monetary value of this object.
     * @return the value of this object
     */
	double getValue();
	
	/**
     * Get the currency of this object.
     * @return the currency of this object
     */
	String getCurrency();
	
}
