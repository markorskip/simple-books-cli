package io.efficientsoftware.simplebookscli.repository.persistence;


import io.efficientsoftware.simplebookscli.model.Fact;
import io.efficientsoftware.simplebookscli.model.MileageEvent;
import io.efficientsoftware.simplebookscli.model.Event;
import io.efficientsoftware.simplebookscli.persistence.IFilePersistence;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

/**
 * Persistence to a file.  Only the Central Repository should communicate with PersistenceService.
 */
@Component
public class FilePersistenceService implements IFilePersistence {

    private String filePath;

    @Override
    public void rewrite(Set<Event> events) {
        if (filePath == null) throw new UnsupportedOperationException("Load a file first");
        createFile();
        deleteFile();
        append(events);
    }

    @Override
    public void append(Event event) {
        if (filePath == null) throw new UnsupportedOperationException("Load a file first");
        append(Set.of(event));
    }

    public void append(Set<Event> events) {
        if (filePath == null) throw new UnsupportedOperationException("Load a file first");
        try{
            File file = new File(filePath);
            if(!file.exists()){
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file,true);
            //BufferedWriter writer give better performance
            BufferedWriter bw = new BufferedWriter(fw);
            for (Event event: events) {
                bw.newLine();
                bw.append(event.toCSV());
            }
            bw.close();
            System.out.println("Data successfully appended at the end of file");

        } catch(IOException ioe){
            ioe.printStackTrace();
        }
    }

     @Override
     public Set<Event> load(String filePath) {
        this.filePath = filePath;
        Path path = Paths.get(filePath);
        try {
            BufferedReader reader = Files.newBufferedReader(path);
            return readEvents(reader);
        } catch (IOException e) {
            createFile();
            return new HashSet<Event>();
        }
    }

    protected void deleteFile() {
         if (filePath != null) {
             Path path = Paths.get(filePath);
             if (Files.exists(path)) {
                 try {
                     Files.delete(path);
                 } catch (IOException e) {
                     throw new RuntimeException(e);
                 }
             }
         }
    }

    protected void createFile() {
        try {
            Files.createFile(Paths.get(filePath));
        } catch (IOException e) {
            System.out.println("Error creating a file: " + filePath);
        }
    }



    private Set<Event> readEvents(BufferedReader reader) {
        Set<Event> events = new HashSet<>();
        String line;
        while (true) {
            try {
                if ((line = reader.readLine()) == null) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            events.add(toEvent(line));
        }
        return events;
    }

    private Event toEvent(String line) {
        if (line.trim().length() == 0) {
            return null;
        }
        // Capture the first
        String[] csv = line.split(",");

        // Determine the event type
        Event.EVENT_TYPE eventType = Event.EVENT_TYPE.valueOf(csv[0]);

        switch (eventType) {
            case MILEAGE -> {
                return new MileageEvent(csv);
            }
            case KEY_VALUE -> {
                return new Fact(csv);
            }
        }
        throw new IllegalArgumentException("Unable to convert line into an event: " + line);
    }
}
