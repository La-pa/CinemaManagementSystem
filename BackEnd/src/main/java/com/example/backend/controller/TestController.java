package com.example.backend.controller;

import com.example.backend.entity.TestTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;


@RestController
@RequestMapping("/test")
public class TestController {


    @PostMapping
    public TestTime test(@RequestBody TestTime testTime) {
        System.out.println(testTime);
        return testTime;
    }

    @GetMapping("/testTime")
    public TestTime testTime() {
        TestTime testTime = new TestTime();
        testTime.setLocalDateTime(LocalDateTime.now());
        testTime.setDate(new Date());
        return testTime;
    }
}