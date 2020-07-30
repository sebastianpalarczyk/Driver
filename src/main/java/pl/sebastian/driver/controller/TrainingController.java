package pl.sebastian.driver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sebastian.driver.DTO.TrainingDto;
import pl.sebastian.driver.assembler.TrainingDtoAssembler;
import pl.sebastian.driver.domain.Training;
import pl.sebastian.driver.service.TrainingService;

@RestController
public class TrainingController {

    private final TrainingService trainingService;
    private final TrainingDtoAssembler trainingDtoAssembler;

    public TrainingController(TrainingService trainingService, TrainingDtoAssembler trainingDtoAssembler) {
        this.trainingService = trainingService;
        this.trainingDtoAssembler = trainingDtoAssembler;
    }

    @PostMapping(value = "/training")
    public TrainingDto create(){
       Training training = trainingService.create();
       return trainingDtoAssembler.toDto(training);
    }

    @GetMapping(value = "/training/{id}")
    public Training one(@PathVariable Long id){
        return trainingService.findById(id);
    }
}
