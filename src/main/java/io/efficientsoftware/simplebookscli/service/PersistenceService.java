package io.efficientsoftware.simplebookscli.service;


import io.efficientsoftware.simplebookscli.model.MileageEvent;
import io.efficientsoftware.simplebookscli.model.core.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

@Component
public class PersistenceService {

    @Autowired
    InMemoryEventStore inMemoryEventStore;

    // This is the event store
    private String filePath;

    // You can only append events or delete them.

    public boolean append(Event event) {
        try{
            //Specify the file name and path here
            File file = new File(filePath);

            /* This logic is to create the file if the
             * file is not already present
             */
            if(!file.exists()){
                file.createNewFile();
            }

            //Here true is to append the content to file
            FileWriter fw = new FileWriter(file,true);
            //BufferedWriter writer give better performance
            BufferedWriter bw = new BufferedWriter(fw);
            bw.newLine();
            bw.append(event.toCSV());
            //Closing BufferedWriter Stream
            bw.close();

            System.out.println("Data successfully appended at the end of file");
            return true;

        } catch(IOException ioe){
            System.out.println("Exception occurred:");
            ioe.printStackTrace();
        }
        return false;
    }

    public boolean delete(Event event) throws Exception {
        // deletes event from the event log
        throw new Exception("Not yet implemented");
        //return true;
    }

    /**
     * Loads all events from a file
     * @param filePath
     * @return
     * @throws IOException
     * @throws URISyntaxException
     */
    public Set<Event> load(String filePath) throws IOException, URISyntaxException {
        this.filePath = filePath;
        Path path = Paths.get(filePath);
        Set<Event> events = new HashSet<>();
        BufferedReader reader = Files.newBufferedReader(path);
        String line;
        while ((line = reader.readLine()) != null) {
            events.add(toEvent(line));
        }
        inMemoryEventStore.setEvents(events);
        return events;
    }

    private Event toEvent(String line) {
        String[] csv = line.split(",");
        Event.EVENT_TYPE eventType = Event.EVENT_TYPE.valueOf(csv[0]);
        switch (eventType) {
            case MILEAGE -> {
                return new MileageEvent(csv);
            }
        }
        System.out.println("Unable to convert line into an event: " + line);
        throw new IllegalArgumentException("Unable to convert line into an event: " + line);
    }
}
