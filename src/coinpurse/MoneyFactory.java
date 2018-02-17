package coinpurse;

public abstract class MoneyFactory {
	
	private static MoneyFactory instance = null;
	
	protected MoneyFactory() {
		
	}
	
	public static MoneyFactory getInstance() {
		if(instance == null) instance = new ThaiMoneyFactory();
		return instance;
	}
	
	public abstract Valuable createMoney(double value) ;
	
	public Valuable createMoney(String value) {
		double valueDb = 0;
	    try {
	       valueDb = Double.parseDouble( value );
	    } catch (IllegalArgumentException ex) {
	        System.out.println(ex.getMessage());
	    } catch (NullPointerException ex) {
	    		System.out.println("There is no value.");
	    		throw new NullPointerException();
		}
	    return createMoney( valueDb );
	}
	
	public static void setFactory(MoneyFactory f) {
		instance = f;
	}
}
