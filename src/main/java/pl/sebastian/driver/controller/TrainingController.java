package pl.sebastian.driver.controller;

import org.springframework.web.bind.annotation.*;
import pl.sebastian.driver.DTO.TrainingDto;
import pl.sebastian.driver.assembler.TrainingDtoAssembler;
import pl.sebastian.driver.domain.Training;
import pl.sebastian.driver.service.TrainingService;

import java.util.List;
import java.util.stream.Collectors;

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
    public TrainingDto one(@PathVariable Long id){
        Training training = trainingService.findById(id);
        return trainingDtoAssembler.toDto(training);
    }

    @GetMapping(value = "/training")
    public List<TrainingDto> all(){
        return trainingService.all().stream()
                .map(training -> trainingDtoAssembler.toDto(training))
                .collect(Collectors.toList());
    }

    @PutMapping(value = "/training/{id}")
    public TrainingDto update(@PathVariable Long id, @RequestBody TrainingDto trainingDto){
        Training training = trainingService.findById(id);
        training.setContent(trainingDto.getContent());
        return trainingDtoAssembler.toDto(trainingService.save(training));
    }

    @DeleteMapping(value = "/training/{id}")
    public TrainingDto delete(@PathVariable Long id){
        Training training = trainingService.findById(id);
        trainingService.delete(training);
        return trainingDtoAssembler.toDto(training);
    }
}
