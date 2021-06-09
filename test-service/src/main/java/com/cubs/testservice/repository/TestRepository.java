package com.cubs.testservice.repository;

import com.cubs.testservice.model.Test;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface TestRepository extends  MongoRepository<Test , Long>{
}
