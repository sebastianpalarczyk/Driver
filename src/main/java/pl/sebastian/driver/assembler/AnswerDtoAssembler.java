package pl.sebastian.driver.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.sebastian.driver.DTO.AnswerDto;
import pl.sebastian.driver.domain.Answer;

@Component
public class AnswerDtoAssembler {

    private final ModelMapper modelMapper;

    public AnswerDtoAssembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
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
