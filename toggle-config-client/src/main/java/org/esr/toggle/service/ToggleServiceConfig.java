package org.esr.toggle.service;

import java.util.Collection;

import org.esr.toggle.dto.ServiceConfigKey;
import org.esr.toggle.dto.Toggle;
import org.esr.toggle.service.exceptions.ToggleConfigException;

public interface ToggleServiceConfig {

	public static final String SERVICE_PATH_PARAM = "service";
	public static final String VERSION_PATH_PARAM = "version";
	public static final String TOGGLE_PATH_PARAM = "toggle";
	public static final String TOGGLE_CONFIG_SERVICE_URI = "service/{service}/{version}"
			+ ToggleGeneralConfig.TOGGLE_CONFIG_GENERAL_URI;

	public Toggle createToggle(Toggle toggleConfig, ServiceConfigKey servicekey)
			throws ToggleConfigException;

	public Toggle updateToggle(Toggle toggleConfig, ServiceConfigKey servicekey)
			throws ToggleConfigException;

	public Toggle retrieveToggle(String toggleKey, ServiceConfigKey servicekey) throws ToggleConfigException;

	public Collection<Toggle> retrieveToggles( ServiceConfigKey servicekey) throws ToggleConfigException;
}
