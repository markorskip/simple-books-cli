package io.efficientsoftware.simplebookscli.model;

import org.jline.utils.Log;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BusinessTest {

    @Test
    public void testAddingAProjectDuplicate() {
        Business business = new Business("test");
        business.addAProject("new project",85.0);
        assertEquals(1, business.getProjects().size());
        business.addAProject("new project",85.0);
        assertEquals(1, business.getProjects().size());
   }

   @Test
   public void testDeletingAProject() {
       Business business = new Business("test");
       String projectName = "new project";
       business.addAProject(projectName,85.0);
       assertEquals(1, business.getProjects().size());
       business.deleteAProject(projectName);
       assertEquals(0, business.getProjects().size());
   }

    @Test
    public void testDeletingAProjectThatDoesntExist() {
        Business business = new Business("test");
        business.addAProject("new project",85.0);
        assertEquals(1, business.getProjects().size());
        assertThrows(IllegalArgumentException.class, () ->business.deleteAProject("doesnt exist"));
    }

    @Test
    public void testDeletingAProjectThatHasTimeRecords() {
        Business business = new Business("test");
        String projectName = "projectName";
        Project project = business.addAProject(projectName,85.0);
        project.addTimeTrackingEntry(new TimeRecord("record"));
        assertEquals(1, business.getProjects().size());
        assertThrows(IllegalArgumentException.class, () ->business.deleteAProject("projectName"));
    }
}
