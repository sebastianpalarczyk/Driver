package pl.sebastian.driver.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.sebastian.driver.DTO.TrainingDto;
import pl.sebastian.driver.domain.Training;

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
