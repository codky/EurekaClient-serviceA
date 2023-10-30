package com.example.firstservice.controller;

import com.example.firstservice.dto.Human;
import com.example.firstservice.feignInterface.FeignTestInterface;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/first-service")
public class FeignTestController {

    private final FeignTestInterface feignTestInterface;

    Logger logger = LoggerFactory.getLogger(FeignTestController.class);

    public FeignTestController(FeignTestInterface feignTestInterface) {
        this.feignTestInterface = feignTestInterface;
    }

    @GetMapping("/feign")
    public List<Human> feign() {
        List<Human> humanResource = feignTestInterface.getHumanResource();
        logger.info("#### humanResource = {} ####",humanResource);
        return humanResource;
    }
}
