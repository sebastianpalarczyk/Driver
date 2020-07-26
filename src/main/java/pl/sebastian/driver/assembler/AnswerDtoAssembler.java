package pl.sebastian.driver.assembler;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.stereotype.Component;
import pl.sebastian.driver.DTO.AnswerDto;
import pl.sebastian.driver.domain.Answer;

@Component
public class AnswerDtoAssembler {

    private ModelMapper modelMapper;

    public AnswerDto toDto(Answer answer){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        AnswerDto answerDto = modelMapper.map(answer,AnswerDto.class);
        return answerDto;
    }

    public Answer fromDto(AnswerDto answerDto){
        Answer answer = new Answer();
        answer.setId(answerDto.getId());
        answer.setContent(answerDto.getContent());
//        answer.setFile(answerDto.getFile());
        return answer;
    }


}
