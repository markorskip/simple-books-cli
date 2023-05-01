package io.efficientsoftware.simplebookscli.transaction;

import io.efficientsoftware.simplebookscli.transaction.model.CategorizationRulesModel;
import io.efficientsoftware.simplebookscli.transaction.model.SimpleTransaction;

public interface TransactionServiceInterface {
	
	
	default SimpleTransaction categorize(SimpleTransaction simpleTransaction, CategorizationRulesModel categorizationRulesModel) {
		if (simpleTransaction.category != null) return simpleTransaction;
		
		//TODO
		return simpleTransaction;
	}
	
	
}

