package coinpurse;

import java.util.ResourceBundle;

/**
 * A main class to create objects and connect objects together.
 * The user interface needs a reference to coin purse.
 * @author your name
 */
public class Main {

    /**
     * Configure and start the application.
     * @param args not used
     */
    public static void main( String[] args ) {
    		init();
    		Purse purse = new Purse(10);
    		ConsoleDialog ui = new ConsoleDialog(purse);
    		ui.run();	
    }
    
    public static void init() {
    		ResourceBundle bundle = ResourceBundle.getBundle( "purse" );
    		String factoryclass = bundle.getString("moneyfactory");
		if (factoryclass == null) factoryclass = "coinpurse.ThaiMoneyFactory";
		MoneyFactory factory = null;
		try {
		    factory = (MoneyFactory)Class.forName(factoryclass).newInstance();
		}
		catch (ClassCastException cce) {
		    System.out.println(factoryclass + " is not type MoneyFactory");
		}
		catch (Exception ex) {
		    System.out.println("Error creating MoneyFactory " + ex.getMessage() );
		}
		MoneyFactory.setFactory(factory);
		if (factory == null) System.exit(1);
    }
}
