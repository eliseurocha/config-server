package org.esr.toggle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import org.esr.toggle.dto.ServiceConfigKey;
import org.esr.toggle.dto.Toggle;
import org.esr.toggle.service.ToggleServiceConfig;
import org.esr.toggle.service.exceptions.ToggleConfigException;
import org.springframework.web.client.RestTemplate;

public class ToggleServiceClient implements ToggleServiceConfig {

	private final RestTemplate restTemplate;

	private final String url;

	public ToggleServiceClient(String url) {
		this.restTemplate = new RestTemplate();
		this.url = url;

	}

	public Toggle createToggle(Toggle toggleConfig, ServiceConfigKey servicekey) throws ToggleConfigException {
		// TODO Auto-generated method stub
		return null;
	}

	public Toggle updateToggle(Toggle toggleConfig, ServiceConfigKey servicekey) throws ToggleConfigException {
		// TODO Auto-generated method stub
		return null;
	}

	public Toggle retrieveToggle(String toggleKey, ServiceConfigKey servicekey) throws ToggleConfigException {
		return this.restTemplate.getForObject(url + TOGGLE_CONFIG_SERVICE_URI +"/{toggle}" , Toggle.class,
				servicekey.getServiceId(), servicekey.getVersion(),toggleKey);

	}

	public Collection<Toggle> retrieveToggles(ServiceConfigKey servicekey) throws ToggleConfigException {
		Collection<Toggle> t = new ArrayList<Toggle>();
		Collection results = this.restTemplate.getForObject(url + TOGGLE_CONFIG_SERVICE_URI, t.getClass(),
				servicekey.getServiceId(), servicekey.getVersion());
		for (Iterator iterator = results.iterator(); iterator.hasNext();) {
			Map object = (Map) iterator.next();
			t.add(new Toggle(object.get("toggleId").toString(), (Boolean) object.get("toggleEnabled")));
		}
		return t;
	}

}
