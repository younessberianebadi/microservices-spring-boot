package com.cubs.trainingtestservice.contoller;

import com.cubs.trainingtestservice.model.Training;
import com.cubs.trainingtestservice.repository.TrainingRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/training")
@RequiredArgsConstructor

public class TrainingContoller {

    private final TrainingRepository trainingRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Training> findAll() {
        return trainingRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createTraining(@RequestBody Training training) {
        trainingRepository.save(training);
    }
}
