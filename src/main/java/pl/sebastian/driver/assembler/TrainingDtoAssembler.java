package pl.sebastian.driver.assembler;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import pl.sebastian.driver.DTO.TrainingDto;
import pl.sebastian.driver.domain.Advice;
import pl.sebastian.driver.domain.Training;
import pl.sebastian.driver.service.TrainingService;

import java.text.ParseException;

@Component
public class TrainingDtoAssembler {

    private ModelMapper modelMapper;

    private final TrainingService trainingService;

    public TrainingDtoAssembler(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    public TrainingDto toDto(Training training){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        TrainingDto trainingDto = modelMapper.map(training, TrainingDto.class);
        return trainingDto;
    }

    public Training fromDto(TrainingDto trainingDto) throws ParseException {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        Training training = modelMapper.map(trainingDto,Training.class);
        if(trainingDto.getId() != 0){
            Training oldTraining = trainingService.getTrainingById(trainingDto.getId());
            training.setId(oldTraining.getId());
        }
        return training;
    }
}
