package coinpurse;

public class MoneyFactoryDemo {
	private final static String[] values = {"0.05","0.25","1.0","2.0","20.0","100","1000", null};
	
	public static void main(String[]args) {
		MoneyFactory factory = MoneyFactory.getInstance();
		MoneyFactory factory2 = MoneyFactory.getInstance();
		System.out.print("Test Singleton: ");
		System.out.println(factory == factory2);
		System.out.println();
		testMoneyFactory(factory);
		System.out.println("\nSet factory to Malaysia factory!!");
		MoneyFactory.setFactory(new MalayMoneyFactory());
		MoneyFactory malayFact = MoneyFactory.getInstance();
		testMoneyFactory(malayFact);
	}
	
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
