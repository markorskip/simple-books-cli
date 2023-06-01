package io.efficientsoftware.simplebookscli.persistence;


import io.efficientsoftware.simplebookscli.modules.mileage.MileageEvent;
import io.efficientsoftware.simplebookscli.model.Event;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

/**
 * Persistence to a file.  Only the Central Repository should communicate with PersistenceService.
 */
@Component
public class PersistenceService {

    private String filePath;

    boolean append(Event event) {
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
            return true;

        } catch(IOException ioe){
            System.out.println("Exception occurred:");
            ioe.printStackTrace();
        }
        return false;
    }


    boolean delete(Event event) throws Exception {
        Set<Event> allEvents = load(this.filePath);
        allEvents.remove(event);

        deleteFile();
        createFile();

        allEvents.forEach(e -> {
            append(e);
        });
        return true;
    }

    private void deleteFile() {
        Path filePath = Paths.get(this.filePath);
        try {
            Files.delete(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Loads all events from a file
     * @param filePath
     * @return
     * @throws IOException
     * @throws URISyntaxException
     */
     Set<Event> load(String filePath) throws IOException {
        this.filePath = filePath;
        Path path = Paths.get(filePath);
        try {
            BufferedReader reader = Files.newBufferedReader(path);
            return readEvents(reader);
        } catch (NoSuchFileException e) {
            System.out.println("File not found. Creating: " + filePath);
            createFile();
            BufferedReader reader = Files.newBufferedReader(path);
            return readEvents(reader);
        }
    }

    private void createFile() {
         try {
             Files.createFile(Paths.get(this.filePath));
         } catch (IOException e) {
             System.out.println("Error creating a file: " + this.filePath);
         }
    }

    private Set<Event> readEvents(BufferedReader reader) throws IOException {
        Set<Event> events = new HashSet<>();
        String line;
        while ((line = reader.readLine()) != null) {
            events.add(toEvent(line));
        }
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
        throw new IllegalArgumentException("Unable to convert line into an event: " + line);
    }
}
