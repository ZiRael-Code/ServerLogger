package com.example.serverlogger.service;

import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Arrays;

import static com.example.serverlogger.dtos.dto.FILENAME;
import static com.example.serverlogger.dtos.dto.runFile;

@Service
public class LoggerImpl implements Logger{
    @Override
    public String getLastLogReqAndRes(String appName) throws Exception{
        runFile(appName);
        String content = getAllLogs(appName);
        System.out.println("Every text i got was "+content);
        String splitting = "=== The Api starting point is === ";
        String[] arrayOfContent = content.split(splitting);
        System.out.println("After splitting "+ Arrays.toString(arrayOfContent));
        String result = arrayOfContent[arrayOfContent.length-1];
        System.out.println("result is " + result);
        return arrayOfContent[arrayOfContent.length-1];
    }

    @Override
    public String getAllLogs(String appName) throws Exception {
        runFile(appName);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILENAME(appName)));
            String line;
            StringBuilder content = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
            reader.close();
            return content.toString();
        } catch (IOException e) {
            throw new Exception(e);
        }
    }

    @Override
    public String writeLog(String log, String appName) throws Exception {
        System.out.println("App name gotten is in the impl"+appName);
        runFile(appName);
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAME(appName), true))) {
            writer.print(log+"\n\n\n");
            return "Written Success";
        } catch (IOException e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public String deleteAllLogs(String appName) throws Exception {
        runFile(appName);
        writeLog("", "");
        return "Deleted successfully";
    }
}
