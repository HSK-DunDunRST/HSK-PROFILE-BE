package com.hskgroup.profile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class LocalBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocalBackEndApplication.class, args);
	}

}
