package com.example.serverlogger.service;

public interface Logger {
    String getLastLogReqAndRes(String appName) throws Exception;
    String getAllLogs(String appName) throws Exception;
    String writeLog(String log, String appName) throws Exception;
    String deleteAllLogs(String appName) throws Exception;

}
