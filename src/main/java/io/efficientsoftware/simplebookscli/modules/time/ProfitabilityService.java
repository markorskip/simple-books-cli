package io.efficientsoftware.simplebookscli.modules.time;

import io.efficientsoftware.simplebookscli.model.Report;
import io.efficientsoftware.simplebookscli.modules.cashflow.CashFlowReportService;
import org.springframework.beans.factory.annotation.Autowired;

public class ProfitabilityService {

    @Autowired
    TimeEventService timeEventService;

    @Autowired
    CashFlowReportService cashFlowReportService;


    public Report generateProfitabilityReport() {
        return null;
    }

}
