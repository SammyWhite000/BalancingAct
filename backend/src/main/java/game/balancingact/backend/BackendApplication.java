package game.balancingact.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main entry point for the Balancing Act backend application. This class is responsible for bootstrapping the Spring Boot application and starting the embedded web server.
 */
@SpringBootApplication
public class BackendApplication {
/**
     * The main method that serves as the entry point for the application. It initializes and runs the Spring Boot application.
     *
     * @param args command-line arguments passed to the application
     */
    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }
}