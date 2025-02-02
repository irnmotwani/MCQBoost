package MCQBoost;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "MCQBoost")
public class McqBoostApplication {

	public static void main(String[] args) {
		SpringApplication.run(McqBoostApplication.class, args);
	}

}
