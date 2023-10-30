package com.example.firstservice.controller;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@EnableFeignClients
@RequestMapping("/first-service")
public class FirstServiceController {

    private Logger logger = LoggerFactory.getLogger(FirstServiceController.class);

    @Value("${server.port}")
    private String port;

    @GetMapping("/check")
    public String check() {
        logger.info("#### port number = {} ####", port);
        return String.format("First Service on PORT %s", port);
    }

    @GetMapping("/post")
    public String writeLogs() {
        try {
            logger.info("#### logs test : info ####");
            logger.error(" logs test error");

        } catch (Exception e) {

        }
        return null;
    }
}
