package pl.sebastian.driver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sebastian.driver.domain.Answer;
import pl.sebastian.driver.service.AnswerService;

@RestController
public class AnswerController {

    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @PostMapping(value = "/answer")
    public Answer create(){
       Answer answer = answerService.create();
       return answerService.save(answer);
    }

    @GetMapping(value = "/answer/{id}")
    public Answer one(@PathVariable Long id){
        return answerService.findById(id);
    }
}
