package com.revature;

import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ImportResource("classpath:spring-config.xml")
@EnableJpaRepositories(basePackages="com.revature.data")
public class Application extends SpringBootServletInitializer {

	private static Logger logger = Logger.getLogger(Application.class);

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		logger.info("Initializing the spring boot");
		return builder.sources(Application.class);
	}
	
	

}
