package pl.sebastian.driver.controller;

import org.springframework.web.bind.annotation.*;
import pl.sebastian.driver.DTO.QuestionDto;
import pl.sebastian.driver.assembler.AnswerDtoAssembler;
import pl.sebastian.driver.assembler.QuestionDtoAssembler;
import pl.sebastian.driver.domain.Question;
import pl.sebastian.driver.service.QuestionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class QuestionController {

    private final QuestionService questionService;
    private final QuestionDtoAssembler questionDtoAssembler;
    private final AnswerDtoAssembler answerDtoAssembler;

    public QuestionController(QuestionService questionService, QuestionDtoAssembler questionDtoAssembler, AnswerDtoAssembler answerDtoAssembler) {
        this.questionService = questionService;
        this.questionDtoAssembler = questionDtoAssembler;
        this.answerDtoAssembler = answerDtoAssembler;
    }

    @PostMapping(value = "/question")
    public QuestionDto create(@RequestBody QuestionDto questionDto) {
        Question question = new Question();
        question.setContent(questionDto.getContent());
        question.setFileId(Long.valueOf(questionDto.getFileId()));
        question.setAnswers(questionDto.getAnswers().stream()
                .map(answerDto -> answerDtoAssembler.fromDto(answerDto))
                .collect(Collectors.toList()));
        question.setTrainingId(Long.valueOf(questionDto.getTrainingId()));
        return questionDtoAssembler.toDto(questionService.save(question));
    }

    @GetMapping(value = "/question/{id}")
    public QuestionDto one(@PathVariable Long id) {
        Question question = questionService.findById(id);
        return questionDtoAssembler.toDto(question);
    }

    @GetMapping(value = "/question")
    public List<QuestionDto> all(){
        return questionService.all().stream()
                .map(question -> questionDtoAssembler.toDto(question))
                .collect(Collectors.toList());
    }

    @PutMapping(value = "/question/{id}")
    public QuestionDto update(@PathVariable Long id, @RequestBody QuestionDto questionDto) {
        Question question = questionService.findById(id);
        question.setContent(questionDto.getContent());
        question.setFileId(Long.valueOf(questionDto.getFileId()));
        question.setAnswers(questionDto.getAnswers().stream()
                .map(answerDto -> answerDtoAssembler.fromDto(answerDto))
                .collect(Collectors.toList()));
        question.setTrainingId(Long.valueOf(questionDto.getTrainingId()));
        return questionDtoAssembler.toDto(questionService.save(question));
    }

    @DeleteMapping(value = "/question/{id}")
    public QuestionDto delete(@PathVariable Long id){
        Question question = questionService.findById(id);
        questionService.delete(question);
        return questionDtoAssembler.toDto(question);
    }
}
