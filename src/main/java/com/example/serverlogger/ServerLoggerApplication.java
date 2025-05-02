package com.example.serverlogger;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@SpringBootApplication
public class ServerLoggerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerLoggerApplication.class, args);
    }

}
