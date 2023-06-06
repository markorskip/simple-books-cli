package io.efficientsoftware.simplebookscli.service;


import io.efficientsoftware.simplebookscli.repository.InitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InitService {

    @Autowired
    private InitRepository initRepository;

    public void load(String filePath) {
        System.out.println("Path Selected: " + filePath);
        this.initRepository.load(filePath);
        System.out.println("******Load Complete******");
    }

}
