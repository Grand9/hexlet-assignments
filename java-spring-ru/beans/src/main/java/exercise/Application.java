package exercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

import exercise.daytime.Daytime;
import exercise.daytime.Day;
import exercise.daytime.Night;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// BEGIN

// END

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // BEGIN
    @Configuration
    class Daytimeconfig {

        @Bean
        public Daytime daytime() {
            LocalDateTime now = LocalDateTime.now();
            int hour = now.getHour();

            if (hour >= 6 && hour < 22) {
                return new Day();
            } else {
                return new Night();
            }
        }
    }

    // END
}