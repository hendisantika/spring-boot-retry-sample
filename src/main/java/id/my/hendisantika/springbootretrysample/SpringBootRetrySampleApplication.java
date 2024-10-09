package id.my.hendisantika.springbootretrysample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@EnableRetry
@SpringBootApplication
public class SpringBootRetrySampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRetrySampleApplication.class, args);
    }

}
