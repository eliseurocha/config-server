package org.esr.toggle;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.esr.toggle.dto.ServiceConfigKey;
import org.esr.toggle.dto.Toggle;
import org.esr.toggle.service.ToggleGeneralConfig;
import org.esr.toggle.service.exceptions.ToggleConfigException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

public class ToggleClientRepository {

	private ServiceConfigKey serviceKey;
	private ToggleServiceClient clientService;
	private final ConcurrentHashMap<String, Boolean> toggles;
	
	private Properties props;

	public ToggleClientRepository(ServiceConfigKey serviceKey, ToggleServiceClient client, Properties props) {

		this.serviceKey = serviceKey;
		this.clientService = client;
		this.props=props;
		this.toggles = new ConcurrentHashMap<String, Boolean>();
		// this.serviceToggles = new ConcurrentHashMap<String, Boolean>();
		try {
			initToggleConfiguration();
		} catch (ToggleConfigException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void initToggleConfiguration() throws ToggleConfigException {
		loadToggleConfiguration();
		initToggleConfigurationChangeListener();
	}

	private void loadToggleConfiguration() throws ToggleConfigException {
		Collection<Toggle> toggleResponse = clientService.retrieveToggles(serviceKey);
		for (Iterator iterator = toggleResponse.iterator(); iterator.hasNext();) {
			Toggle toggle = (Toggle) iterator.next();
			this.toggles.put(toggle.getToggleId(), toggle.getToggleEnabled());
		}
	}

	private void initToggleConfigurationChangeListener() {

		KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
		consumer.subscribe(Arrays.asList(ToggleGeneralConfig.TOPIC_TOGGLE_CONFIG_GENERAL));

		new Thread(new ToggleGeneralConfigListener(consumer)).start();

	}

	private class ToggleGeneralConfigListener implements Runnable {
		private KafkaConsumer<String, String> consumer = null;

		public ToggleGeneralConfigListener(KafkaConsumer<String, String> consumer) {
			this.consumer = consumer;
		}

		public void run() {
			while (true) {
				ConsumerRecords<String, String> records = consumer.poll(100);
				for (ConsumerRecord<String, String> record : records) {

					Toggle config = new Gson().fromJson(record.value(), Toggle.class);
					try {
						Toggle toggleResponse = clientService.retrieveToggle(config.getToggleId(), serviceKey);
						toggles.put(toggleResponse.getToggleId(), toggleResponse.getToggleEnabled());
					} catch (ToggleConfigException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(),
							record.value());
				}
			}
		}

	}

	/**
	 * Return if toggle requested is on
	 * 
	 * @param featureId
	 * @return
	 */
	public boolean isToggleOn(ApplicationToggle toggle) {
		if (toggle == null || toggle.getKey() == null)
			return false;
		else {
			Boolean value = toggles.get(toggle.getKey());
			return value != null ? value.booleanValue() : false;
		}

	}

}
