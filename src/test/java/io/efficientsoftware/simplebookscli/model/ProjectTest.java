package io.efficientsoftware.simplebookscli.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProjectTest {

    @Test
    void testAddingDuplicateTimeEntries() {
        Project project = new Project("test", 0.0);
        LocalDate now = LocalDate.now();
        project.addTimeTrackingEntry(new TimeRecord(now,"test",8.0));
        project.addTimeTrackingEntry(new TimeRecord(now,"test",8.0));
        assertEquals(1,project.getTimeTrackingLog().size());
    }

    @Test
    void testDeletingTimeEntry() {
        Project project = new Project("test", 0.0);
        TimeRecord entry = new TimeRecord(LocalDate.now(),"test",8.0) ;
        project.addTimeTrackingEntry(entry);
        assertEquals(1,project.getTimeTrackingLog().size());
        project.deleteTimeTrackingEntry(entry);
        assertEquals(0,project.getTimeTrackingLog().size());
    }
}
