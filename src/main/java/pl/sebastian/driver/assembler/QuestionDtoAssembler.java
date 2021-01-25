package pl.sebastian.driver.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.sebastian.driver.DTO.QuestionDto;
import pl.sebastian.driver.domain.Question;

@Component
public class QuestionDtoAssembler {

    private final  ModelMapper modelMapper;

    public QuestionDtoAssembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public QuestionDto toDto(Question question){
        QuestionDto questionDto = modelMapper.map(question, QuestionDto.class);
        return questionDto;
    }

    public Question fromDto(QuestionDto questionDto){
       Question question = modelMapper.map(questionDto,Question.class);
       return question;
    }
}
