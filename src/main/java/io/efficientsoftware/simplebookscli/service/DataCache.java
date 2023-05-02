package io.efficientsoftware.simplebookscli.service;

import org.springframework.stereotype.Service;

import io.efficientsoftware.simplebookscli.model.Business;
import lombok.Data;

@Service
@Data
public class DataCache {
	
	private Business business;
	private String ownerName;

}
