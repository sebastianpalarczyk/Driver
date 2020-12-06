package pl.sebastian.driver.controller;

import org.springframework.web.bind.annotation.*;
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
    public TrainingDto create(@RequestBody TrainingDto trainingDto){
       Training training = trainingDtoAssembler.fromDto(trainingDto);
       return trainingDtoAssembler.toDto(trainingService.save(training));
    }

    @GetMapping(value = "/training/{id}")
    public Training one(@PathVariable Long id){
        return trainingService.findById(id);
    }
}
