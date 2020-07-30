package pl.sebastian.driver.assembler;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import pl.sebastian.driver.DTO.QuestionDto;
import pl.sebastian.driver.domain.Question;
import pl.sebastian.driver.service.QuestionService;

@Component
public class QuestionDtoAssembler {

    private final  ModelMapper modelMapper;

    private final QuestionService questionService;

    public QuestionDtoAssembler(ModelMapper modelMapper, QuestionService questionService) {
        this.modelMapper = modelMapper;
        this.questionService = questionService;
    }

    public QuestionDto toDto(Question question){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        QuestionDto questionDto = modelMapper.map(question, QuestionDto.class);
        return questionDto;
    }

    public Question fromDto(QuestionDto questionDto){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        Question question = modelMapper.map(questionDto,Question.class);
        if(questionDto.getId() != 0){
            Question oldQuestion = questionService.getQuestionById(questionDto.getId());
            question.setId(oldQuestion.getId());
        }
        return question;
    }
}
