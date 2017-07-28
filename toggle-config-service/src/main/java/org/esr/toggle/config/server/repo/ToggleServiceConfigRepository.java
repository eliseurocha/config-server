package org.esr.toggle.config.server.repo;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

import org.esr.toggle.dto.ServiceConfigKey;

public class ToggleServiceConfigRepository {

	private static final Map<ServiceConfigKey, Properties> servicesConfiguration = new ConcurrentHashMap<ServiceConfigKey, Properties>();
	
	

}
