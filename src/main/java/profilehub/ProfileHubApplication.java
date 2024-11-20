package profilehub;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProfileHubApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ProfileHubApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Application started successfully!");
    }
}
