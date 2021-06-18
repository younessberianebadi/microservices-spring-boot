package com.cubs_test.test.controller;

import com.cubs_test.test.entities.Test;
import com.cubs_test.test.repository.TestRepository;
import com.cubs_test.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.cubs_test.test.exception.ResourceNotFoundException;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    TestService testService;

    @Autowired
    private TestRepository testRepository;

    @GetMapping("tests")
    public List<Test> getTests(){
        return testService.getTests();
    }

    @PostMapping("add_test")
    public Test SaveTest(@RequestBody Test test){
        return testService.saveTest(test);
    }

    @GetMapping("tests/{id}")
    public ResponseEntity<Test>  getJoueurById(@PathVariable(value="id") Long testId)
            throws ResourceNotFoundException{
        Test test =testRepository.findById(testId)
                .orElseThrow(()-> new ResourceNotFoundException("Joueur not found  for this id::" + testId ));
        return ResponseEntity.ok().body(test);
    }
}
