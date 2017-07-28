package org.esr.toggle.config.server.rest;

import org.esr.toggle.dto.ToggleConfig;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "config/toggle")
public class ToggleConfigServiceREST {

//
//	@RequestMapping(method=RequestMethod.POST)
//	public ResponseEntity<ToggleConfig> create(ToggleConfig toggleConfig){
//		
//		 toggleConfig = toggleConfigService.create(toggleConfig);
//		
//		return new ResponseEntity<ToggleConfig>(toggleConfig,HttpStatus.OK);
//	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<ToggleConfig> retrieve(){
		return new ResponseEntity<ToggleConfig>(new ToggleConfig(),HttpStatus.OK);
	}

	
}
