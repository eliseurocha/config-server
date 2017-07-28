package org.esr.toggle.config.server.repo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.esr.toggle.dto.ServiceConfigKey;
import org.esr.toggle.dto.Toggle;
import org.springframework.stereotype.Component;

@Component
public class ToggleServiceConfigRepository {

	private static final Map<ServiceConfigKey, Map<String, Toggle>> servicesConfiguration = new ConcurrentHashMap<ServiceConfigKey, Map<String, Toggle>>();

	public Toggle save(Toggle toggle, ServiceConfigKey serviceKey) {
		Map<String, Toggle> toggleServiceMap = new LinkedHashMap<String, Toggle>();
		if (servicesConfiguration.containsKey(serviceKey)) {
			toggleServiceMap = servicesConfiguration.get(serviceKey);
		}
		toggleServiceMap.put(toggle.getToggleId(), toggle);
		servicesConfiguration.put(serviceKey, toggleServiceMap);
		return toggle;
	}

	public Toggle getToggle(String toggleKey, ServiceConfigKey serviceKey) {
		if (servicesConfiguration.containsKey(serviceKey)) {
			return servicesConfiguration.get(serviceKey).get(toggleKey);
		}
		return null;
	}

	public Collection<Toggle> getToggles(ServiceConfigKey serviceKey) {
		if (servicesConfiguration.containsKey(serviceKey)) {
			return new ArrayList<Toggle>(servicesConfiguration.get(serviceKey).values());
		}
		return null;

	}

}
