package io.efficientsoftware.simplebookscli.repository;


import io.efficientsoftware.simplebookscli.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class TimekeepingRepository {

    @Autowired
    private CentralRepository centralRepository;

    public void addHourlyContract(Project project) {
        this.centralRepository.getProjects().add(project);
    }

    public Project getProjectByName(String contractName) {
        if (contractName == null) {
            return this.centralRepository.getProjects().stream().findFirst().get();
        }
        return this.centralRepository
                .getProjects().stream()
                .filter(x-> x.getName().toLowerCase().equals(contractName.toLowerCase())).findFirst().get();
    }

    public Set<Project> getProjects() {
        return this.centralRepository.getProjects();
    }

    public void deleteProject(Project project) {
        this.centralRepository.getProjects().remove(project);
    }
}
