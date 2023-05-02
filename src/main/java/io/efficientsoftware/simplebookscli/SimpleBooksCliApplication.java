package io.efficientsoftware.simplebookscli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimpleBooksCliApplication {

	/**
	 * SimpleBooksCLI has to answer two questions.
	 * 
	 * How is better then a spreadsheet?
	 * -Can use custom business rules to auto-categorize transactions, making it simple to bulk import transactions
	 * and see expense and income categories
	 * -Keeps out duplicate data
	 * -Enforces strict typing of data - no invalid data can be added
	 * -Less user error
	 * 
	 * 
	 * How is better then a paid online bookkeeping service?
	 * -doesn't store your data
	 * -doesn't require login, privacy concerms, and browser
	 * -doesn't charge monthly - one time low cost of $10
	 * -can run offline
	 * -your data is your data
	 *  
	 *  How is it worse then a spreadsheet?
	 *  -A spreadsheet you track whatever you want, however you want.  This software enforces 
	 *  a pattern.
	 *  
	 *  
	 *  How is it worse then an online bookkeepign service?
	 *  Online bookkeeping services might have better customer service, more features, and cloud storage allowing
	 *  you to login anywhere.
	 *  
	 *  That being said, if you store the program on dropbox or another cloud provider, you can run the program and access
	 *  your data on any machine.
	 *  
	 *  Also, because it's a CLI, it requires Java to be installed. (double check this - can it be packaged with jre?)
	 * 
	 */
	public static void main(String[] args) {
		SpringApplication.run(SimpleBooksCliApplication.class, args);
	}

}
