package io.efficientsoftware.simplebookscli.service;

public class AutoService {

    public double amountDeductibleWithStandardMileageRate(int businessMilesForGivenYear, double mileageRate) {
        return businessMilesForGivenYear * mileageRate;
    }

    public double percentageBusinessUse(int startingYearMiles, int endingYearMiles, int businessMilesForGivenYear) {
        int totalMiles =  endingYearMiles - startingYearMiles;
        return businessMilesForGivenYear / totalMiles;
    }

    // Don't forget about vehicle depreciation!!!!
    //double deductibleDirectExpense(double percentageBusinessUse, double totalAutoExpenditures);

}
