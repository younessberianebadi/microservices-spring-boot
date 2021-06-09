package com.cubs_test.test.controller;

import com.cubs_test.test.entities.Test;
import com.cubs_test.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping("get_tests")
    public List<Test> getTests(){
        return testService.getTests();
    }

    @PostMapping("add_test")
    public Test SaveTest(@RequestBody Test test){
        return testService.saveTest(test);
    }
}
