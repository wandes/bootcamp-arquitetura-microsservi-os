package br.com.hereos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class HereosConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HereosConfigServerApplication.class, args);
	}

}
