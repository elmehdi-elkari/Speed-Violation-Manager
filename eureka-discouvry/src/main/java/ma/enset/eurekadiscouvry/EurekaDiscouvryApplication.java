package ma.enset.eurekadiscouvry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaDiscouvryApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaDiscouvryApplication.class, args);
	}

}
