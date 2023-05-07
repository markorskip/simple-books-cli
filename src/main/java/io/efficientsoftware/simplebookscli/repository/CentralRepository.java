package io.efficientsoftware.simplebookscli.repository;


import io.efficientsoftware.simplebookscli.model.Business;
import io.efficientsoftware.simplebookscli.model.Project;
import io.efficientsoftware.simplebookscli.persistence.JacksonPersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * Handles all read and write operations to the DataCache.  The CentralRepository
 * should only be accessed by other repositories.  It should never be accessed directly
 * from a service.
 */
@Component
public class CentralRepository {

    @Autowired
    private DataCache dataCache;

    @Autowired
    private JacksonPersistenceService persistenceService;

    public CentralRepository(DataCache dataCache) {
        this.dataCache = dataCache;
    }

    public void setBusiness(Business business, String fileToSaveTo) {
        Business oldBusiness = this.dataCache.getBusiness();
        String oldFilePath = this.dataCache.fileToSaveTo;
        try {
            this.dataCache.fileToSaveTo = fileToSaveTo;
            this.dataCache.setBusiness(business);
            this.persistenceService.save(fileToSaveTo);
            System.out.println("New Business created and saved to: " + fileToSaveTo);
        } catch (Exception e){
            System.out.println(e);
            System.out.println("Error creating new business - restoring old business and file to save to");
            this.dataCache.setBusiness(oldBusiness);
            this.dataCache.fileToSaveTo = oldFilePath;
        }
    }

    public Set<Project> getProjects() {
        return this.dataCache.getBusiness().getProjects();
    }

    public String getFileName() {
        return this.dataCache.fileToSaveTo;
    }

    public void setFileName(String file) {
        this.dataCache.fileToSaveTo = file;
    }

    public void view() {
        System.out.println(this.dataCache.toString());
    }
}
