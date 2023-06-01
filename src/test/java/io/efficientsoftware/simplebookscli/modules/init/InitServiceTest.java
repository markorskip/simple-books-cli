package io.efficientsoftware.simplebookscli.modules.init;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@SpringBootTest
public class InitServiceTest {

    @Autowired
    private InitService initService;

    private String FILE_NAME = "text.csv";

    @AfterAll
    @BeforeAll
    public void cleanUpFiles() {
        File targetFile = new File(FILE_NAME);
        targetFile.delete();
    }

    @Test
    public void testLoadDoesNotExist() {
        File targetFile = new File(FILE_NAME);
        targetFile.delete();
        initService.load(FILE_NAME);
    }

    @Test
    public void testLoadFileAlreadyExists() throws IOException {
        Files.createFile(Path.of(FILE_NAME));
        initService.load(FILE_NAME);
    }

}
