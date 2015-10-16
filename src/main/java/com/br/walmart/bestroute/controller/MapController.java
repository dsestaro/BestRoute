package com.br.walmart.bestroute.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.br.walmart.bestroute.dto.CitiesMap;

@RestController
@RequestMapping("/rest")
public class MapController {
	
	@RequestMapping(method=RequestMethod.GET, value="/getMap")
    public CitiesMap getMap() {
        return null;
    }
	
	@RequestMapping(method=RequestMethod.POST, value="/setMap")
    public void setMap(CitiesMap map) {
		
		
        return;
    }
}
