package co.flight.searchms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SearchMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SearchMsApplication.class, args);
	}

}
