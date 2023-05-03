package io.efficientsoftware.simplebookscli.service;

import io.efficientsoftware.simplebookscli.model.Business;
import io.efficientsoftware.simplebookscli.repository.DataCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellOption;
import org.springframework.stereotype.Component;

import java.io.*;

/**
 * The service handles loading a business and saving a business to a file.
 */
@Component
public class PersistenceService {

    @Autowired
    private DataCache dataCache;

    public void save(String arg) throws IOException {
        FileOutputStream fileOutputStream
                = new FileOutputStream(arg);
        ObjectOutputStream objectOutputStream
                = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(this.dataCache.getBusiness());
        objectOutputStream.flush();
        objectOutputStream.close();
        System.out.println("All data saved to file: " + arg);
    }

    public void load(String arg
    ) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream
                = new FileInputStream(arg);
        ObjectInputStream objectInputStream
                = new ObjectInputStream(fileInputStream);
        Business business = (Business) objectInputStream.readObject();
        objectInputStream.close();
        this.dataCache.setBusiness(business);
        System.out.println("Loaded data from file: " + arg);
    }
}
