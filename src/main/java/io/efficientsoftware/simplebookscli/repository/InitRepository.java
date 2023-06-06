package io.efficientsoftware.simplebookscli.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InitRepository  {

    @Autowired
    private CentralRepository centralRepository;

    public void load(String filePath) {
        this.centralRepository.load(filePath);
    }
}
