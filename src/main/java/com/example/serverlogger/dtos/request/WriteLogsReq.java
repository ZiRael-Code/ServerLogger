package com.example.serverlogger.dtos.request;

import lombok.Data;

@Data
public class WriteLogsReq {
String message;
String appName;
}
