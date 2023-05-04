package io.efficientsoftware.simplebookscli.persistence;

import java.io.FileNotFoundException;
import java.io.IOException;

public class CustomPersistenceService implements PersistenceInterface {

    @Override
    public void load(String filepath) throws FileNotFoundException, Exception {
        // read from file

        // convert to object
    }

    @Override
    public void save(String filepath) throws IOException {
        // convert to flat file

        // save to file
    }
}
