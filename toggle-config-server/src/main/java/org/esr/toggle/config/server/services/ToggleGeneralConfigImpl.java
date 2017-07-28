package org.esr.toggle.config.server.services;

import java.util.Collection;
import java.util.List;

import org.esr.toggle.config.server.ToggleNotificationProducer;
import org.esr.toggle.config.server.repo.ToggleGeneralConfigRepository;
import org.esr.toggle.dto.Toggle;
import org.esr.toggle.service.ToggleGeneralConfig;
import org.esr.toggle.service.exceptions.ToggleConfigException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToggleGeneralConfigImpl implements ToggleGeneralConfig {

	@Autowired
	private ToggleGeneralConfigRepository repository;
	@Autowired
	private ToggleNotificationProducer notificationProducer;

	public Toggle createToggle(Toggle toggleConfig) throws ToggleConfigException {
		toggleConfig = repository.save(toggleConfig);
		notificationProducer.notify(toggleConfig);
		return toggleConfig;
	}

	public Toggle updateToggle(Toggle toggleConfig) throws ToggleConfigException {
		// TODO Auto-generated method stub
		return null;
	}

	public Toggle retrieveToggle(String toggleKey) throws ToggleConfigException {
		// TODO Auto-generated method stub
		return repository.getToggle(toggleKey);
	}

	public Collection<Toggle> retrieveToggles() throws ToggleConfigException {
		// TODO Auto-generated method stub
		return repository.getToggleConfigs();
	}

}
