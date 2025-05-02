package com.example.serverlogger.controller;

import com.example.serverlogger.dtos.request.WriteLogsReq;
import com.example.serverlogger.service.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/logger")
@RestController
public class LoggerController {
    @Autowired
    private Logger logger;

    @GetMapping("/getLastLog/{appName}")
    public ResponseEntity<String> getLastLogReAndRes(@PathVariable String appName){
        try {
            return ResponseEntity.ok(logger.getLastLogReqAndRes(appName));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getAllLogs/{appName}")
    public ResponseEntity<String> getAllLogReqAndRes(@PathVariable String appName){
        try {
            return ResponseEntity.ok(logger.getAllLogs(appName));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping("/writeLog")
    public ResponseEntity<String> writeLogs(@RequestBody WriteLogsReq req){
        try {
            System.out.println("App name gotten is in the controller "+req.getAppName());
            return ResponseEntity.ok(logger.writeLog(req.getMessage(), req.getAppName()));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/deleteAllLog/{appName}")
    public ResponseEntity<String> deleteAllLogs(@PathVariable String appName){
        try {
            return ResponseEntity.ok(logger.deleteAllLogs(appName));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
