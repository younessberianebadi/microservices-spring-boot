package com.cubs_test.test.service;

import com.cubs_test.test.entities.Test;
import com.cubs_test.test.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    @Autowired TestRepository testRepository;

    public TestService(){

    }

    public List<Test> getTests(){
        return testRepository.findAll();
    }

    public Test saveTest(Test test) {
        return testRepository.save(test);
    }
}
