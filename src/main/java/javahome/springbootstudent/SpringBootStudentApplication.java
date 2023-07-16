package javahome.springbootstudent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootStudentApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootStudentApplication.class);

	public static void main(String[] args) {
		LOGGER.info("Application starts");
		SpringApplication.run(SpringBootStudentApplication.class, args);
		LOGGER.warn("Now you can start your requests");
	}

}
