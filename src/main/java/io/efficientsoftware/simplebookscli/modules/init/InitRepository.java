package io.efficientsoftware.simplebookscli.modules.init;

import io.efficientsoftware.simplebookscli.persistence.CentralRepository;
import org.springframework.stereotype.Repository;

@Repository
public class InitRepository extends CentralRepository  {

    protected void load(String filePath) {
        load(filePath);
    }
}
