package io.efficientsoftware.simplebookscli.persistence;

import io.efficientsoftware.simplebookscli.model.Business;
import io.efficientsoftware.simplebookscli.model.Project;
import io.efficientsoftware.simplebookscli.model.TimeRecord;
import io.efficientsoftware.simplebookscli.repository.DataCache;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class JacksonPersistenceServiceTest {

    @Test
    void testSave() throws IOException {
        // Given
        DataCache dataCache = new DataCache();
        Business business = new Business("test business llc");
        Project project = business.addAProject("new project", 85.0);
        project.addTimeTrackingEntry(new TimeRecord("did some work"));

        // when
        dataCache.setBusiness(business);
        JacksonPersistenceService service =
                new JacksonPersistenceService(dataCache);
        service.save("test.json");
    }

    @Test
    void testLoad() throws IOException {
        // Given
        DataCache dataCache = new DataCache();
        JacksonPersistenceService service =
                new JacksonPersistenceService(dataCache);
        service.load("data.json");
    }
}
