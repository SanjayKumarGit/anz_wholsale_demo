package com.anz.wholesale.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.anz.wholesale.repository")
public class AnzConfigurationRepo {
}
