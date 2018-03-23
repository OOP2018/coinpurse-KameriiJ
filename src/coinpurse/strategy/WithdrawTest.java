package coinpurse.strategy;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import coinpurse.Money;
import coinpurse.Valuable;

/**
 * Test the GreedyWithdraw by using JUnit.
 * @author Gunthee Tawewatmongkol
 */
public class WithdrawTest {
	private List<Valuable> money;
	private GreedyWithdraw greedy;
	
	 /**
     * Sets up the test fixture.
     * Called before every test method.
     */
	@Before
	private void setUp() {
		money = new ArrayList<Valuable>();
		greedy = new GreedyWithdraw();
	}
	
	/** Check if Amount of items in money before withdraw and after withdraw are equals. */
	@Test
	public void testChangingMoney() {
		money.add(new Money(10, "Baht"));
		money.add(new Money(20, "Baht"));
		money.add(new Money(1, "Baht"));
		money.add(new Money(1, "Ringgit"));
		money.add(new Money(5, "Ringgit"));
		money.add(new Money(5, "Baht"));
		int listSize = money.size();
		Valuable val1 = new Money(31, "Baht");
		greedy.withdraw(val1 ,money);
		
		/* Amount of items in Money should not be changed. */
		assertEquals(listSize, money.size());
		
		Valuable val2 = new Money(10, "Ringgit");
		greedy.withdraw(val2 ,money);
		
		/* Amount of items in Money should not be changed. */
		assertEquals(listSize, money.size());
	}
	
	/** Check if the solution containing the items that have the same currency with the actual value. */
	@Test
	public void testSameCurrentWithdraw() {
		money.add(new Money(10, "Baht"));
		money.add(new Money(20, "Baht"));
		money.add(new Money(1, "Baht"));
		money.add(new Money(1, "Ringgit"));
		money.add(new Money(5, "Ringgit"));
		money.add(new Money(5, "Baht"));
		Valuable val = new Money(31, "Baht");
		List<Valuable> solution = greedy.withdraw(val ,money);
		
		/* It should return list containing 1, 10 Baht coins and 20 Baht Banknote. */
		assertEquals(3, solution.size());
		/* Every items should have "Baht" currency. */
		for(Valuable v : solution) {
			assertEquals("Baht", v.getCurrency());
		}
		/* List sould be sorted. */
		assertEquals(new Money(1, "Baht"), solution.get(0));
	}
	
	/** 
	 * Check the case that have many possible solutions.
	 * For example, there are two 10 Baht coins and one 20 Baht banknote in money list.
	 * When you withdraw 20 Baht, It should return the list containing 20 Baht banknote.
	 * Check if the solution contains the largest amount that equals the target. 
	 */
	@Test
	public void testMutiPossibleCases() {
		money.add(new Money(10, "Baht"));
		money.add(new Money(10, "Baht"));
		money.add(new Money(20, "Baht"));
		money.add(new Money(5, "Ringgit"));
		money.add(new Money(5, "Ringgit"));
		money.add(new Money(10, "Ringgit"));
		
		Valuable val1 = new Money(20, "Baht");
		List<Valuable> solution1 = greedy.withdraw(val1 ,money);
		
		/* Solution should contain the largest amount that equals the target. (20 Baht banknote not two 10 Bath coins) */
		assertEquals(new Money(20, "Baht"), solution1.get(0));
		/* Solution should contain only one item(20 Baht banknote). */
		assertEquals(1, solution1.size());
		
		Valuable val2 = new Money(10, "Ringgit");
		List<Valuable> solution2 = greedy.withdraw(val2 ,money);
		
		/* Solution should contain the largest amount that equals the target. (10 Ringgit Banknote not two 5 Ringgit banknotes) */
		assertEquals(new Money(10, "Ringgit"), solution2.get(0));
		/* Solution should contain only one item(10 Ringgit banknote). */
		assertEquals(1, solution2.size());
	}
	
	/** 
	 * Check invalid value or currency case.
	 * Should be return null because a solution is not found. 
	 */
	@Test
	public void testImpossibleCase() {
		money.add(new Money(1, "Baht"));
		money.add(new Money(1, "Ringgit"));
		
		Valuable val1 = new Money(100, "Baht");
		/* It should return null, if a solution is not found. */
		assertNull(greedy.withdraw(val1, money));
		
		Valuable val2 = new Money(1, "Dollar");
		/* It should return null, if a solution is not found. */
		assertNull(greedy.withdraw(val2, money));
	}
	
	/** 
	 * Check the case that money list is empty.
	 * Should be return null because a solution is not found. 
	 */
	@Test
	public void testWithdrawEmptyMoney() {
		int listSize = money.size();
		/* Money should empty */
		assertEquals(0, listSize);
		
		Valuable val1 = new Money(10, "Baht");
		/* It should return null, if a solution is not found. */
		assertNull(greedy.withdraw(val1, money));
		
		Valuable val2 = new Money(5, "Ringgit");
		/* It should return null, if a solution is not found. */
		assertNull(greedy.withdraw(val2, money));
	}
	
	/** 
	 * Check the case that withdraw null.
	 * Should be return empty list because a solution is found(withdraw nothing). 
	 */
	@Test
	public void testWithDrawEmptyValuable() {
		money.add(new Money(10, "Baht"));
		/* It should return empty list, because there is a solution(withdraw nothing). */
		assertEquals(0, greedy.withdraw(null, money).size());
		
		money.add(new Money(1, "Ringgit"));
		money.add(new Money(5, "Ringgit"));
		/* It should return empty list, because there is a solution(withdraw nothing). */
		assertEquals(0, greedy.withdraw(null, money).size());
	}
	
//	@Test
	public void testWithDrawEveryThing() {
		money.add(new Money(10, "Baht"));
		money.add(new Money(20, "Baht"));
		money.add(new Money(1, "Baht"));
		money.add(new Money(1, "Ringgit"));
		money.add(new Money(5, "Ringgit"));
		money.add(new Money(5, "Baht"));
		int listSize = money.size();
	}

}
