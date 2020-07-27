package pl.sebastian.driver.assembler;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import pl.sebastian.driver.DTO.QuestionDto;
import pl.sebastian.driver.domain.Question;

@Component
public class QuestionDtoAssembler {

    private ModelMapper modelMapper;

    public QuestionDto toDto(Question question){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        QuestionDto questionDto = modelMapper.map(question, QuestionDto.class);
        return questionDto;
    }

    public Question fromDto(QuestionDto questionDto){
        Question question = new Question();
        question.setId(questionDto.getId());
        question.setContent(questionDto.getContent());
        return question;
    }
}
