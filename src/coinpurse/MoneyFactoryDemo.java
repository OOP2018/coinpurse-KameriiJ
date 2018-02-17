package coinpurse;

/**
 * MoneyFactoryDemo class to create a MoneyFactory and call its methods
 * and print results on the console.
 * 
 * @author Gunthee tawewatmongkol
 */
public class MoneyFactoryDemo {
	private final static String[] values = {"0.05","0.25","1.0","2.0","20.0","100","1000", null};
	
	/**
	 * Check MoneyFactory is a singleton
	 * and all the methods work as specified.
	 */
	public static void main(String[]args) {
		MoneyFactory factory = MoneyFactory.getInstance();
		MoneyFactory factory2 = MoneyFactory.getInstance();
		System.out.print("Test Singleton: ");
		System.out.println(factory == factory2);
		System.out.println();
		System.out.println("Set default factory to Thai factory!!");
		testMoneyFactory(factory);
		System.out.println("\nSet factory to Malaysia factory!!");
		MoneyFactory.setFactory(new MalayMoneyFactory());
		MoneyFactory malayFact = MoneyFactory.getInstance();
		testMoneyFactory(malayFact);
	}
	
	/**
	 * Create money object.
	 * @param factory is instance to create money.
	 */
	public static void testMoneyFactory(MoneyFactory factory) {
		for(String val : values) {
			System.out.print("Create: ");
			try {
				Valuable v = factory.createMoney(val);
				System.out.println(v.toString());
			}catch(IllegalArgumentException ex) {
				System.out.println("IllegalArgumentException:" + ex.getMessage());
				continue;
			}catch(NullPointerException ex) {
				System.out.println("IllegalArgumentException: " + ex.getMessage());
				continue;
			}
		}
	}
}
