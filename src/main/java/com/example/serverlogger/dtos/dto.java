package com.example.serverlogger.dtos;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class dto {
    public static String FILENAME(String appName){
        String FILENAME = String.format("src/main/java/com/example/serverlogger/log_folders/%s.txt",appName);;
        String envPath = System.getenv("FILE_PATH");
        if (envPath != null && !envPath.trim().isEmpty()) {
            FILENAME = envPath.trim();
            System.out.printf("Using FILE_PATH from environment: {%s}", FILENAME);
        } else {
            System.out.printf("FILE_PATH not set in environment, using default: {%s}", FILENAME);
        }

        return FILENAME;
    }
    public static void runFile(String appName) {
        try {
            System.out.println("in run file app name is"+appName);
//            String envPath = System.getenv("FILE_PATH");
//            if (envPath != null && !envPath.trim().isEmpty()) {
//                FILENAME = envPath.trim();
//                System.out.printf("Using FILE_PATH from environment: {%s}", FILENAME);
//            } else {
//                System.out.printf("FILE_PATH not set in environment, using default: {%s}", FILENAME);
//            }

            Path path = Paths.get(FILENAME(appName));
            Files.createDirectories(path.getParent());

            File file = path.toFile();
            if (file.createNewFile()) {
                System.out.printf("Created new file at: {%s}", path.toAbsolutePath());
            } else {
                System.out.printf("File already exists at: {%s}", path.toAbsolutePath());
            }
            if (!file.canWrite()) {
                throw new IOException("File is not writable: " + path.toAbsolutePath());
            }
        } catch (IOException e) {
            System.out.printf("Failed to initialize data file %s", e);
           throw new RuntimeException("Sorry there is no such log file with name "+appName);
        }
    }
}
