package io.efficientsoftware.simplebookscli;


import io.efficientsoftware.simplebookscli.modules.cashflow.expense.DirectExpenseCommands;
import io.efficientsoftware.simplebookscli.modules.init.InitCommands;
import io.efficientsoftware.simplebookscli.persistence.CentralRepository;
import io.efficientsoftware.simplebookscli.persistence.PersistenceService;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.text.TabExpander;

@SpringBootTest
public class FullApplicationTest {

    @Autowired
    InitCommands initCommands;

    @Autowired
    DirectExpenseCommands directExpenseCommands;

    //@Autowired
    // RevenueCommands, MileageCommands, etc...

    private final String TESTFILE = "test.csv";

    // TODO all commands

    @Test
    public void testRegularUsage() {
        // When a user logs in the load a file
        initCommands.load(TESTFILE);

        // Then they log expenses, revenue, and mileage, auto expenses, home office expesnes
        directExpenseCommands.logDirectExpense("1/1/2022", "100","Checking","Internet",null,null);

        // they may update facts


        // Then they run reports
        // Assert all these commands work
        directExpenseCommands.displayAllDirectExpenses();

        assert(true);
    }

    @Autowired
    private PersistenceService persistenceService;

    @AfterAll
    public void cleanUp() {
        persistenceService.deleteFile(TESTFILE);
    }
}
