package pl.sebastian.driver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sebastian.driver.domain.Question;
import pl.sebastian.driver.service.QuestionService;

@Controller
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping(value = "/question")
    public Question create(){
        return questionService.save(questionService.create());
    }

    @GetMapping(value = "/question/{id}")
    public Question one(@PathVariable Long id){
        return questionService.findById(id);
    }
}
