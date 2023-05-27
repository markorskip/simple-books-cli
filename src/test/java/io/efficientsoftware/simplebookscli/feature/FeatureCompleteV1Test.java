package io.efficientsoftware.simplebookscli.feature;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * This test, when complete, marks the application as v1 Feature Complete
 */
public class FeatureCompleteV1Test {

    /**
     * -Log time, money (direct expense, revenue, auto), mileage - NOT A FEATURE, a prereq to create reports
     * -Persist locally to an event_store, append and delete  - NOT A FEATURE, a prereq to operate between runs
     * -Generate reports for expenses, revenue, profitability reports - FEATURES
     * -View logs for a date range for auto, expenses, revenue, and timeworked - FEAURE
     */

    @Test
    public void testExpenseReportFeature() {
        // Given X number of expenses

        // Generate expense report

        // Then expect an accurate expense report
        assertTrue(true);
    }

    @Test
    public void testRevenueReportFeature() {
        // Given X number of revenue events

        // Generate revenue report

        // Then expect an accurate revenue report
        assertTrue(true);
    }

    @Test
    public void testProfitabilityReportFeature() {
        // Given X number of revenue, expense, and time logs

        // Generate profitability report

        // Then expect an accurate report
        assertTrue(true);
    }
}

