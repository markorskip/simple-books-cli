package io.efficientsoftware.simplebookscli.modules.time;

import java.time.LocalDate;
import java.time.Month;
import java.util.Set;

public class TimeService {

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
