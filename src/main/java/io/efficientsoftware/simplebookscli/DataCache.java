package io.efficientsoftware.simplebookscli;

import io.efficientsoftware.simplebookscli.model.Business;
import org.springframework.stereotype.Service;

@Service
public class DataCache {

    public Business business = new Business();
}
