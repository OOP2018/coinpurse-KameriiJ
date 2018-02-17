package coinpurse;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * MoneyFactoryTest class containing JUnit tests of MoneyFactory methods.
 * 
 * @author Gunthee tawewatmongkol
 */
public class MoneyFactoryTest {
	private final static String[] thaiMoney = {"1","2","5","10","20","50","100","1000"};
	private final static String[] malayMoney = {"0.05","0.1","0.2","0.5","1","2","5","10","20","50","100"};
	
	/** Create all kinds of Thai money */
	@Test
	public void testThaiMoneyFactory() {
		MoneyFactory.setFactory(new ThaiMoneyFactory());
		MoneyFactory factory = MoneyFactory.getInstance();
		for(String val : thaiMoney) {
			double value = Double.parseDouble(val);
			Valuable v = factory.createMoney(val);
			if(value >= 20) {
				assertEquals(new BankNote(value, "Baht"), v);	
			}
			else {
				assertEquals(new Coin(value, "Baht"), v);
			}
		}
	}
	
	/** Create all kinds of Malaysia money */
	@Test
	public void testMalayMoneyFactory() {
		MoneyFactory.setFactory(new MalayMoneyFactory());
		MoneyFactory factory3 = MoneyFactory.getInstance();
		for(String val : malayMoney) {
			double value = Double.parseDouble(val);
			Valuable v = factory3.createMoney(val);
			if(value >= 1) {
				assertEquals(new BankNote(value, "Ringgit"), v);	
			}
			else if(value < 1){
				assertEquals(new Coin(value, "Ringgit"), v);
			}
		}
	}
}
