package io.efficientsoftware.simplebookscli.persistence;

import io.efficientsoftware.simplebookscli.model.Fact;
import io.efficientsoftware.simplebookscli.model.Event;
import io.efficientsoftware.simplebookscli.modules.auto.mileage.MileageEvent;
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
        centralRepository.add(event);
        assertEquals(1, centralRepository.readEvents().size());
    }

    @Test
    public void testDelete()  {
        centralRepository.load(FILE_NAME);
        Event event = new MileageEvent("1/1/2022","Chevy","100","store");
        centralRepository.add(event);
        assertEquals(1, centralRepository.readEvents().size());

        centralRepository.delete(event);
        assertEquals(0, centralRepository.readEvents().size());
    }

    @Test
    public void testUpdate() {
        centralRepository.load(FILE_NAME);
        Event event = new Fact("Business Name", "Efficient Software LLC");
        centralRepository.add(event);
        assertEquals(1, centralRepository.readEvents().size());
        Fact businessFact = (Fact) centralRepository.readEvents().stream().findFirst().get();
        assertEquals("Business Name", businessFact.getKey());
        assertEquals("Efficient Software LLC", businessFact.getValue());

        Event event2 = new Fact("Business Name", "Efficient Software LLC 2.0");
        centralRepository.update(event,event2);
        assertEquals(1, centralRepository.readEvents().size());
        businessFact = (Fact) centralRepository.readEvents().stream().findFirst().get();
        assertEquals("Business Name", businessFact.getKey());
        assertEquals("Efficient Software LLC 2.0", businessFact.getValue());
    }
}
