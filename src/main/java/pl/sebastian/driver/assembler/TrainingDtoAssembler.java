package pl.sebastian.driver.assembler;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import pl.sebastian.driver.DTO.TrainingDto;
import pl.sebastian.driver.domain.Training;

@Component
public class TrainingDtoAssembler {

    private ModelMapper modelMapper;

    public TrainingDto toDto(Training training){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        TrainingDto trainingDto = modelMapper.map(training, TrainingDto.class);
        return trainingDto;
    }

    public Training fromDto(TrainingDto trainingDto){
        Training training = new Training();
        training.setId(trainingDto.getId());
        return training;
    }
}
