package pl.sebastian.driver.assembler;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import pl.sebastian.driver.DTO.TrainingDto;
import pl.sebastian.driver.domain.Training;
import pl.sebastian.driver.service.TrainingService;

import java.text.ParseException;

@Component
public class TrainingDtoAssembler {

    private final ModelMapper modelMapper;

    public TrainingDtoAssembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public TrainingDto toDto(Training training){
        TrainingDto trainingDto = modelMapper.map(training, TrainingDto.class);
        return trainingDto;
    }

    public Training fromDto(TrainingDto trainingDto)  {
        Training training = modelMapper.map(trainingDto,Training.class);
        return training;
    }
}
