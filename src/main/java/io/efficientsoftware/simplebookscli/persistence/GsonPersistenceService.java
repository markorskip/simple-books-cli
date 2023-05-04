package io.efficientsoftware.simplebookscli.persistence;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.efficientsoftware.simplebookscli.model.Business;
import io.efficientsoftware.simplebookscli.repository.DataCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;

/**
 * The service handles loading a business and saving a business to a file.
 */
@Component
public class GsonPersistenceService implements PersistenceInterface {

    @Autowired
    private DataCache dataCache;

    public void save(String arg) throws IOException {
        String filePath = arg;
        Writer writer = new FileWriter(filePath);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        gson.toJson(this.dataCache.getBusiness(), writer);
        System.out.println(writer.toString());
        System.out.println("All data serialized and saved to file: " + arg);
    }

    public void load(String arg
    ) throws FileNotFoundException {
        String filePath = arg;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Business deserializedBusiness = gson.fromJson(new FileReader(filePath), Business.class);
        System.out.println(deserializedBusiness);
        this.dataCache.setBusiness(deserializedBusiness);
        System.out.println("Loaded data from file: " + arg);
    }
}
