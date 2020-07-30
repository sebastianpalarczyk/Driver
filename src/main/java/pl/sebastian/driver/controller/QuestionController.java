package pl.sebastian.driver.controller;

import org.springframework.web.bind.annotation.*;
import pl.sebastian.driver.DTO.QuestionDto;
import pl.sebastian.driver.assembler.QuestionDtoAssembler;
import pl.sebastian.driver.domain.Question;
import pl.sebastian.driver.service.QuestionService;

@RestController
public class QuestionController {

    private final QuestionService questionService;
    private final QuestionDtoAssembler questionDtoAssembler;

    public QuestionController(QuestionService questionService, QuestionDtoAssembler questionDtoAssembler) {
        this.questionService = questionService;
        this.questionDtoAssembler = questionDtoAssembler;
    }

    @PostMapping(value = "/question")
    public QuestionDto create(@RequestBody QuestionDto questionDto){
        Question question = questionDtoAssembler.fromDto(questionDto);

        return questionDtoAssembler.toDto(questionService.save(question));
    }

    @GetMapping(value = "/question/{id}")
    public Question one(@PathVariable Long id){
        return questionService.findById(id);
    }

    @PutMapping(value = "/question/{id}")
    public QuestionDto update(@PathVariable Long id, @RequestBody QuestionDto questionDto){
        Question byId = questionService.findById(id);
        byId.setContent(questionDto.getContent());

        return questionDtoAssembler.toDto(questionService.save(byId));
    }
}
