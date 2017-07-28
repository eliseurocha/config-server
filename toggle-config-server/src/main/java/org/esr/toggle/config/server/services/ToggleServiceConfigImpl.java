package org.esr.toggle.config.server.services;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.esr.toggle.config.server.ToggleNotificationProducer;
import org.esr.toggle.config.server.repo.ToggleServiceConfigRepository;
import org.esr.toggle.dto.ServiceConfigKey;
import org.esr.toggle.dto.Toggle;
import org.esr.toggle.service.ToggleGeneralConfig;
import org.esr.toggle.service.ToggleServiceConfig;
import org.esr.toggle.service.exceptions.ToggleConfigException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToggleServiceConfigImpl implements ToggleServiceConfig {

	@Autowired
	private ToggleServiceConfigRepository repository;

	@Autowired
	private ToggleGeneralConfig toggleGeneralService;

	@Autowired
	private ToggleNotificationProducer producer;

	public Toggle createToggle(Toggle toggle, ServiceConfigKey servicekey) throws ToggleConfigException {
		// TODO Auto-generated method stub
		toggle = repository.save(toggle, servicekey);
		producer.notify(toggle);
		return toggle;
	}

	public Toggle updateToggle(Toggle toggleConfig, ServiceConfigKey servicekey) throws ToggleConfigException {
		// TODO Auto-generated method stub
		return null;
	}

	public Toggle retrieveToggle(String toggleKey, ServiceConfigKey servicekey) throws ToggleConfigException {

		Toggle toggle = repository.getToggle(toggleKey, servicekey);
		if (toggle == null) {
			toggle = toggleGeneralService.retrieveToggle(toggleKey);
		}

		return toggle;
	}

	public Collection<Toggle> retrieveToggles(ServiceConfigKey servicekey) throws ToggleConfigException {
		Collection<Toggle> toggles = toggleGeneralService.retrieveToggles();

		Collection<Toggle> togglesService = repository.getToggles(servicekey);

		return merge(toggles, togglesService);
	}

	private Collection<Toggle> merge(Collection<Toggle> toggles, Collection<Toggle> togglesService) {
		Map<String, Toggle> toggleMap = new HashMap<String, Toggle>();
		if (toggles != null) {
			for (Iterator iterator = toggles.iterator(); iterator.hasNext();) {
				Toggle toggle = (Toggle) iterator.next();
				toggleMap.put(toggle.getToggleId(), toggle);
			}
		}
		if (togglesService != null) {
			for (Iterator iterator = togglesService.iterator(); iterator.hasNext();) {
				Toggle toggle = (Toggle) iterator.next();
				toggleMap.put(toggle.getToggleId(), toggle);
			}
		}

		// TODO Auto-generated method stub
		return toggleMap.values();
	}

}
