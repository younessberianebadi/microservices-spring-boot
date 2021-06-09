package com.cubs.testservice.controller;

import com.cubs.testservice.model.Test;
import com.cubs.testservice.repository.TestRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/test")
@RequiredArgsConstructor

public class TestController {

    private final TestRepository testRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Test> findAll() {
        return testRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createTest(@RequestBody Test test) {
        testRepository.save(test);
    }
}
