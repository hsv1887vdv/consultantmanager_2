package com.akra.consultantmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchDataAutoConfiguration;

@SpringBootApplication(exclude = ElasticsearchDataAutoConfiguration.class)
public class ConsultantmanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsultantmanagerApplication.class, args);
	}

}
