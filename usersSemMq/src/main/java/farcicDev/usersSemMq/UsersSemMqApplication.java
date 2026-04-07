package farcicDev.usersSemMq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class UsersSemMqApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersSemMqApplication.class, args);
	}

}
