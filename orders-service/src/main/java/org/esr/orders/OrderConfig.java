package org.esr.orders;

import java.util.Properties;
import java.util.UUID;

import org.esr.toggle.ToggleClientRepository;
import org.esr.toggle.ToggleServiceClient;
import org.esr.toggle.dto.ServiceConfigKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfig {
	@Value("${spring.application.name}")
	private String service;

	@Value("${spring.application.version}")
	private String version;

	@Value("${toggle.service.host}")
	private String hostName;

	@Value("${toggle.service.port}")
	private String port;

	@Value("${kafka.port}")
	private String zkPort;

	@Bean
	public ServiceConfigKey getServiceKey() {
		return new ServiceConfigKey(service, version);
	}

	@Bean
	public ToggleServiceClient getToggleService() {
		return new ToggleServiceClient(hostName + ":" + port);

	}

	@Bean
	public ToggleClientRepository getRepository() {
		return new ToggleClientRepository(getServiceKey(), getToggleService(), getKafkaProperties());
	}

	@Bean
	public Properties getKafkaProperties() {
		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:" + zkPort);
		props.put("group.id", UUID.randomUUID().toString());
		props.put("enable.auto.commit", "true");
		props.put("auto.commit.interval.ms", "1000");
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		return props;
	}

}
