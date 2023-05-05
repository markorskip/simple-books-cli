package io.efficientsoftware.simplebookscli.modules.persistence;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface PersistenceInterface {

    void load(String filepath) throws FileNotFoundException, Exception;

    void save(String filepath) throws IOException;
}
