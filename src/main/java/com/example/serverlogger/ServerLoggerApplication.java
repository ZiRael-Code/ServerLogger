package com.example.serverlogger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

@EnableScheduling
@SpringBootApplication
public class ServerLoggerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ServerLoggerApplication.class, args);
    }

    private static final String API_URL = "https://serverlogger-h77l.onrender.com/logger/getLastLog/TestLog";
    private final RestTemplate restTemplate = new RestTemplate();
    @Scheduled(fixedRate = 10 * 60 * 1000)
    public void callApiEvery10Minutes() {
        try {
            System.out.println("in call api meod: " + java.time.LocalDateTime.now());
            restTemplate.getForObject(API_URL, String.class);
            System.out.println("API called successfully at: " + java.time.LocalDateTime.now());
        } catch (Exception e) {
            System.err.println("Failed to call API: " + e.getMessage());
        }
    }

    @Override
    public void run(String... args) throws Exception {
        callApiEvery10Minutes();
    }
}
