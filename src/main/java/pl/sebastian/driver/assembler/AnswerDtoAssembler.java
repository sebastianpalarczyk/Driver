package pl.sebastian.driver.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.sebastian.driver.DTO.AnswerDto;
import pl.sebastian.driver.domain.Answer;
import pl.sebastian.driver.service.AnswerService;

@Component
public class AnswerDtoAssembler {

    private final ModelMapper modelMapper;
    private final AnswerService answerService;

    public AnswerDtoAssembler(ModelMapper modelMapper, AnswerService answerService) {
        this.modelMapper = modelMapper;
        this.answerService = answerService;
    }

    public AnswerDto toDto(Answer answer){
        AnswerDto answerDto = modelMapper.map(answer,AnswerDto.class);
        return answerDto;
    }

    public Answer fromDto(AnswerDto answerDto){
        Answer answer = modelMapper.map(answerDto,Answer.class);
        return answer;
    }


}
