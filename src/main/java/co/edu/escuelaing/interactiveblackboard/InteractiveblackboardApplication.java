package co.edu.escuelaing.interactiveblackboard;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InteractiveblackboardApplication {

	public static void main(String[] args) {
	SpringApplication app = new SpringApplication(InteractiveblackboardApplication.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", getPort()));
		app.run(args);
	
	}

	static int getPort() {
		if (System.getenv("PORT") != null) {
			return Integer.parseInt(System.getenv("PORT"));
		}
		return 8080; // returns default port if PORT isn't set (i.e. on localhost)
	}

}
