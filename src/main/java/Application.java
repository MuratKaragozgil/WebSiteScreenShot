import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Murat Karagözgil
 */
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan("com.challenge")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
