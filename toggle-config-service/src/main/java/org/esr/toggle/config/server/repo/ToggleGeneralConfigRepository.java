package org.esr.toggle.config.server.repo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ToggleGeneralConfigRepository {

	private static final Map<String, Boolean> generalConfiguration = new ConcurrentHashMap<String, Boolean>();


	public static Map<String, Boolean> getGeneralconfiguration() {
		return generalConfiguration;
	}

}
