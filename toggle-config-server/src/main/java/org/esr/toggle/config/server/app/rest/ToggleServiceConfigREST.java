package org.esr.toggle.config.server.app.rest;

import static org.esr.toggle.service.ToggleServiceConfig.SERVICE_PATH_PARAM;
import static org.esr.toggle.service.ToggleServiceConfig.TOGGLE_CONFIG_SERVICE_URI;
import static org.esr.toggle.service.ToggleServiceConfig.VERSION_PATH_PARAM;

import java.util.Collection;

import org.esr.toggle.dto.ServiceConfigKey;
import org.esr.toggle.dto.Toggle;
import org.esr.toggle.service.ToggleServiceConfig;
import org.esr.toggle.service.exceptions.ToggleConfigException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = TOGGLE_CONFIG_SERVICE_URI)
public class ToggleServiceConfigREST {

	@Autowired
	private ToggleServiceConfig service;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Toggle> create(@RequestBody Toggle request,
			@PathVariable(name = SERVICE_PATH_PARAM) String serviceId,
			@PathVariable(name = VERSION_PATH_PARAM) String versionId) throws ToggleConfigException {

		return new ResponseEntity<Toggle>(service.createToggle(request, new ServiceConfigKey(serviceId, versionId)),
				HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<Toggle>> retrieve(@PathVariable(name = SERVICE_PATH_PARAM) String serviceId,
			@PathVariable(name = VERSION_PATH_PARAM) String versionId) throws ToggleConfigException {
		return new ResponseEntity<Collection<Toggle>>(
				service.retrieveToggles(new ServiceConfigKey(serviceId, versionId)), HttpStatus.OK);
	}

	@RequestMapping(value="/{"+ToggleServiceConfig.TOGGLE_PATH_PARAM+"}", method = RequestMethod.GET)
	public ResponseEntity<Toggle> retrieve(@PathVariable(name = SERVICE_PATH_PARAM) String serviceId,
			@PathVariable(name = VERSION_PATH_PARAM) String versionId,
			@PathVariable(name = ToggleServiceConfig.TOGGLE_PATH_PARAM) String toggle) throws ToggleConfigException {
		return new ResponseEntity<Toggle>(
				service.retrieveToggle(toggle, new ServiceConfigKey(serviceId, versionId)), HttpStatus.OK);
	}

}
