package org.esr.toggle.config.server.app.rest;

import java.util.Collection;

import org.esr.toggle.dto.Toggle;
import org.esr.toggle.service.ToggleGeneralConfig;
import org.esr.toggle.service.exceptions.ToggleConfigException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = ToggleGeneralConfig.TOGGLE_CONFIG_GENERAL_URI)
public class ToggleGeneralConfigREST {

	@Autowired
	private ToggleGeneralConfig service;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Toggle> create(@RequestBody Toggle request) throws ToggleConfigException {

		return new ResponseEntity<Toggle>(service.createToggle(request), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<Toggle>> retrieve() throws ToggleConfigException {
		return new ResponseEntity<Collection<Toggle>>(service.retrieveToggles(), HttpStatus.OK);
	}
	


}
