package coinpurse;

public class MoneyFactoryDemo {
	public static void main(String[]args) {
		MoneyFactory factory = MoneyFactory.getInstance();
		Valuable m = factory.createMoney( 5 );
		System.out.println(m.toString());
		Valuable m2 = factory.createMoney("1000.0");
		System.out.println(m2.toString());
		
		MoneyFactory.setFactory(new MalayMoneyFactory());
		MoneyFactory factory2 = MoneyFactory.getInstance();
		m = factory2.createMoney( 5 );
		System.out.println(m.toString());
		Valuable m3 = factory2.createMoney( 0.05 );
		System.out.println(m3.toString());
	}
}
