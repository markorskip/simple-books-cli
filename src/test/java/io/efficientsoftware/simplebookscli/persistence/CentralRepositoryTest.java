package io.efficientsoftware.simplebookscli.persistence;

import io.efficientsoftware.simplebookscli.model.event.KeyValueEvent;
import io.efficientsoftware.simplebookscli.model.event.Event;
import io.efficientsoftware.simplebookscli.modules.mileage.MileageEvent;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class CentralRepositoryTest {

    @Autowired
    CentralRepository centralRepository;

    private String FILE_NAME = "text.csv";

    @AfterEach
    @BeforeEach
    public void cleanUpFiles() {
        File targetFile = new File(FILE_NAME);
        targetFile.delete();
    }

    @Test
    public void testAdd() {
        centralRepository.load(FILE_NAME);
        Event event = new MileageEvent("1/1/2022","Chevy","100","store");
        assertEquals(0, centralRepository.readEvents().size());
        centralRepository.createOrUpdate(event);
        assertEquals(1, centralRepository.readEvents().size());
    }

    //@Test
    public void testDelete()  {
        centralRepository.load(FILE_NAME);
        Event event = new MileageEvent("1/1/2022","Chevy","100","store");
        centralRepository.createOrUpdate(event);
        assertEquals(1, centralRepository.readEvents().size());

        centralRepository.delete(event);
        assertEquals(0, centralRepository.readEvents().size());
    }

//    @Test
    public void testUpdate() {
        centralRepository.load(FILE_NAME);
        Event event = new KeyValueEvent("Business Name", "Efficient Software LLC");
        centralRepository.createOrUpdate(event);
        assertEquals(1, centralRepository.readEvents().size());
        event = new KeyValueEvent("Business Name", "Efficient Software LLC 2.0");
        centralRepository.createOrUpdate(event);
        assertEquals(1, centralRepository.readEvents().size());
    }
}
