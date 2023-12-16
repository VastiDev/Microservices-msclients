package net.atlassian.vastidev.msclients;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.EurekaClientConfigBean;

@SpringBootApplication
@EnableEurekaClient
public class MsclientsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsclientsApplication.class, args);
	}

}
