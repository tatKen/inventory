package ken.ball.inventory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class InventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext cts){
		return args -> {
			System.out.println("Let's inspect the beans provided by Spring Boot:");
			String[] beansName = cts.getBeanDefinitionNames();
			Arrays.stream(beansName).sorted().forEach(System.out::println);
		};
	}

}
