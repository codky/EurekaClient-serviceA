package com.example.firstservice.feignInterface;

import com.example.firstservice.dto.Human;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "feignStudy2", url = "localhost:8085/example/human")
public interface FeignTestInterface {

    @GetMapping(produces = "application/json")
    public List<Human> getHumanResource();
}
