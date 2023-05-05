package io.efficientsoftware.simplebookscli.persistence;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface PersistenceInterface {

    void load(String filepath) throws Exception;

    void save(String filepath) throws IOException;
}
