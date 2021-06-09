package com.cubs.trainingtestservice.repository;

import com.cubs.trainingtestservice.model.Training;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TrainingRepository extends MongoRepository<Training, Long>{
}
