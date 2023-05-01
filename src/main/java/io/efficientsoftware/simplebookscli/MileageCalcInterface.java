package io.efficientsoftware.simplebookscli;

public interface MileageCalcInterface {
	
	default double amountDeductibleWithStandardMilageRate(int businessMilesForGivenYear, double mileageRate) {
		return businessMilesForGivenYear * mileageRate;
	}
	
	
	default double percentageBusinessUse(int startingYearMiles, int endingYearMiles, int businessMilesForGivenYear) {
		int totalMiles =  endingYearMiles - startingYearMiles;
		return businessMilesForGivenYear / totalMiles;
	}
	
	// Don't forget about vehicle depreciation!!!!
	double deductibleDirectExpense(double percentageBusinessUse, double totalAutoExpenditures);
	
}
