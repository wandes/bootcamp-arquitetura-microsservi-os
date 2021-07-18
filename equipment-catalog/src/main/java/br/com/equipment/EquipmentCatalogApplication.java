package br.com.equipment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
public class EquipmentCatalogApplication {

	public static void main(String[] args) {
		SpringApplication.run(EquipmentCatalogApplication.class, args);
	}

}
