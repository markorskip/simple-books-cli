package io.efficientsoftware.simplebookscli.persistence;


import io.efficientsoftware.simplebookscli.modules.auto.mileage.MileageEvent;
import io.efficientsoftware.simplebookscli.model.Event;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

/**
 * Persistence to a file.  Only the Central Repository should communicate with PersistenceService.
 */
@Component
public class PersistenceService implements IFilePersistence {

    private String filePath;

    public PersistenceService(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void append(Event event) {
        try{
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

        } catch(IOException ioe){
            System.out.println("Exception occurred:");
            ioe.printStackTrace();
        }
    }

    /**
     * Loads all events from a file
     * @return
     * @throws IOException
     * @throws URISyntaxException
     */
     @Override
     public Set<Event> load() {
        Path path = Paths.get(filePath);
        try {
            BufferedReader reader = Files.newBufferedReader(path);
            return readEvents(reader);
        } catch (IOException e) {
            System.out.println("File not found. Creating: " + filePath);
            createFile();
            BufferedReader reader = null;
            try {
                reader = Files.newBufferedReader(path);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            return readEvents(reader);
        }
    }

    @Override
    public void deleteFile() {
        Path path = Paths.get(filePath);
        if (Files.exists(path)) {
            try {
                Files.delete(path);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    @Override
    public void createFile() {
        try {
            Files.createFile(Paths.get(filePath));
        } catch (IOException e) {
            System.out.println("Error creating a file: " + filePath);
        }
    }


    public void writeToFile(Set<Event> events) {
        for (Event event: events) {
            append(event);
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
        String[] csv = line.split(",");
        Event.EVENT_TYPE eventType = Event.EVENT_TYPE.valueOf(csv[0]);
        switch (eventType) {
            case MILEAGE -> {
                return new MileageEvent(csv);
            }
        }
        throw new IllegalArgumentException("Unable to convert line into an event: " + line);
    }
}
