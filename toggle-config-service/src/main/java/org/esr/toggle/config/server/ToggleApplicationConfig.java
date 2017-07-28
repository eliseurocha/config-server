package org.esr.toggle.config.server;

import org.esr.toggle.config.server.repo.ToggleGeneralConfigRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ToggleApplicationConfig {

	@Bean
	public ToggleGeneralConfigRepository getApplicationConfigRepository()
	{
		return new ToggleGeneralConfigRepository();
	}
}
