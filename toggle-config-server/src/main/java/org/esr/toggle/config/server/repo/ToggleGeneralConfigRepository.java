package org.esr.toggle.config.server.repo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.esr.toggle.dto.Toggle;
import org.springframework.stereotype.Component;

@Component
public class ToggleGeneralConfigRepository {

	private static final Map<String, Toggle> generalConfiguration = new ConcurrentHashMap<String, Toggle>();

	public Toggle save(Toggle toggleConfig) {
		generalConfiguration.put(toggleConfig.getToggleId(), toggleConfig);
		return toggleConfig;
	}

	public Collection<Toggle> getToggleConfigs() {

		return new ArrayList<Toggle>(generalConfiguration.values());
	}

	public Toggle getToggle(String toggleKey) {
		// TODO Auto-generated method stub
		return generalConfiguration.get(toggleKey);
	}

}
