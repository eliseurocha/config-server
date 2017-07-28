package org.esr.toggle.config.server;

import java.util.UUID;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.esr.toggle.dto.ServiceConfigKey;
import org.esr.toggle.dto.Toggle;
import org.esr.toggle.service.ToggleGeneralConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
public class ToggleNotificationProducer {

	@Autowired
	private Producer<String, String> producer;

	public void notify(Toggle newToggle) {

		String json = new Gson().toJson(newToggle);
		producer.send(new ProducerRecord<String, String>(ToggleGeneralConfig.TOPIC_TOGGLE_CONFIG_GENERAL,
				UUID.randomUUID().toString(), json));

	}

}
