package pl.sebastian.driver.assembler;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import pl.sebastian.driver.DTO.AnswerDto;
import pl.sebastian.driver.domain.Advice;
import pl.sebastian.driver.domain.Answer;
import pl.sebastian.driver.service.AnswerService;

@Component
public class AnswerDtoAssembler {

    private ModelMapper modelMapper;

    private final AnswerService answerService;

    public AnswerDtoAssembler(AnswerService answerService) {
        this.answerService = answerService;
    }

    public AnswerDto toDto(Answer answer){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        AnswerDto answerDto = modelMapper.map(answer,AnswerDto.class);
        return answerDto;
    }

    public Answer fromDto(AnswerDto answerDto){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        Answer answer = modelMapper.map(answerDto,Answer.class);
        if(answerDto.getId() != 0){
            Answer oldAnswer = answerService.getAnswerById(answerDto.getId());
            answer.setId(oldAnswer.getId());
        }
        return answer;
    }


}
