package io.efficientsoftware.simplebookscli.calc;

import io.efficientsoftware.simplebookscli.model.TimeEvent;

import java.time.LocalDate;
import java.time.Month;
import java.util.Set;

public class TimeRecordCalc {

    public static double getTotalNoOfHoursWorked(Set<TimeEvent> timeRecords) {
        return timeRecords.stream().mapToDouble(TimeEvent::getHours).sum();
    }

    public static double getHoursWorkedThisMonth(Set<TimeEvent> timeRecords) {
        Month thisMonth = LocalDate.now().getMonth();
        return timeRecords.stream()
                .filter(x->x.getDate().getMonth() == thisMonth)
                .mapToDouble(TimeEvent::getHours).sum();
    }
}
