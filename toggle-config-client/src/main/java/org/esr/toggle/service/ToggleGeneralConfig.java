package org.esr.toggle.service;

import java.util.Collection;

import org.esr.toggle.dto.ServiceConfigKey;
import org.esr.toggle.dto.Toggle;
import org.esr.toggle.service.exceptions.ToggleConfigException;

public interface ToggleGeneralConfig {
	public static final ServiceConfigKey GENERAL_CONFIG_KEY = new ServiceConfigKey("toggle-config", "1.0");
	public static final String TOPIC_TOGGLE_CONFIG_GENERAL = "toggle-config-general";
	public static final String TOGGLE_CONFIG_GENERAL_URI = "/config/toggle";

	public Toggle createToggle(Toggle toggleConfig) throws ToggleConfigException;

	public Toggle updateToggle(Toggle toggleConfig) throws ToggleConfigException;

	public Toggle retrieveToggle(String toggleKey) throws ToggleConfigException;

	public Collection<Toggle> retrieveToggles() throws ToggleConfigException;
}
