package io.efficientsoftware.simplebookscli.persistence;

import io.efficientsoftware.simplebookscli.model.Business;
import io.efficientsoftware.simplebookscli.repository.DataCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;

/**
 * The service handles loading a business and saving a business to a file.
 */
@Component
public class JavaPersistenceService implements PersistenceInterface {

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
    ) throws Exception {
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
