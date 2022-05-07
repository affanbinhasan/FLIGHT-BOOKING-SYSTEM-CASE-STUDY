package co.flight.checkinms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CheckInMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CheckInMsApplication.class, args);
	}

}
