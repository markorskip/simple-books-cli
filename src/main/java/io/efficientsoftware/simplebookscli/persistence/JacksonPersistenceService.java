package io.efficientsoftware.simplebookscli.persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
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
public class JacksonPersistenceService implements PersistenceInterface {

    @Autowired
    private DataCache dataCache;

    public void save(String arg) throws IOException {
        File file = new File(arg);
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(file, this.dataCache.getBusiness());
        System.out.println("All data serialized and saved to file: " + arg);
    }

    public void load(String arg) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Business deserializedBusiness = mapper.readValue(new File(arg), Business.class);
        this.dataCache.setBusiness(deserializedBusiness);
        System.out.println("Loaded data from file: " + arg);
    }
}
