package pl.sebastian.driver.controller;

import org.springframework.web.bind.annotation.*;
import pl.sebastian.driver.DTO.QuestionDto;
import pl.sebastian.driver.assembler.AnswerDtoAssembler;
import pl.sebastian.driver.assembler.QuestionDtoAssembler;
import pl.sebastian.driver.domain.Question;
import pl.sebastian.driver.service.QuestionService;

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
        Question question = questionDtoAssembler.fromDto(questionDto);
        return questionDtoAssembler.toDto(questionService.save(question));
    }

    @GetMapping(value = "/question/{id}")
    public Question one(@PathVariable Long id) {
        return questionService.findById(id);
    }

    @PutMapping(value = "/question/{id}")
    public QuestionDto update(@PathVariable Long id, @RequestBody QuestionDto questionDto) {
        Question question = questionService.findById(id);
        question.setContent(questionDto.getContent());
        question.setFileId(Long.valueOf(questionDto.getFileId()));
        question.setAnswers(questionDto.getAnswers().stream()
                .map(answerDto -> answerDtoAssembler.fromDto(answerDto))
                .collect(Collectors.toList()));
        return questionDtoAssembler.toDto(questionService.save(question));
    }
}
