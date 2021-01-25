package pl.sebastian.driver.controller;

import org.springframework.web.bind.annotation.*;
import pl.sebastian.driver.DTO.AnswerDto;
import pl.sebastian.driver.assembler.AnswerDtoAssembler;
import pl.sebastian.driver.domain.Answer;
import pl.sebastian.driver.service.AnswerService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AnswerController {

    private final AnswerService answerService;
    private final AnswerDtoAssembler answerDtoAssembler;

    public AnswerController(AnswerService answerService, AnswerDtoAssembler answerDtoAssembler) {
        this.answerService = answerService;
        this.answerDtoAssembler = answerDtoAssembler;
    }

    @PostMapping(value = "/answer")
    public AnswerDto create(@RequestBody AnswerDto answerDto){
       Answer answer = answerDtoAssembler.fromDto(answerDto);
       return answerDtoAssembler.toDto(answerService.save(answer));
    }

    @GetMapping(value = "/answer/{id}")
    public AnswerDto one(@PathVariable Long id){
        Answer answer = answerService.getAnswerById(id);
        return answerDtoAssembler.toDto(answer);
    }

    @GetMapping(value = "/answer")
    public List<AnswerDto> all(){
        return answerService.all().stream()
                .map(answer -> answerDtoAssembler.toDto(answer))
                .collect(Collectors.toList());
    }

    @PutMapping(value = "/answer/{id}")
    public AnswerDto update(@PathVariable Long id, @RequestBody AnswerDto answerDto){
        Answer answer = answerService.getAnswerById(id);
        answer.setContent(answerDto.getContent());
        answer.setFileId(Long.valueOf(answerDto.getFileId()));
        return answerDtoAssembler.toDto(answerService.save(answer));
    }

    @DeleteMapping(value = "/answer/{id}")
    public AnswerDto delete(Answer answer){
        answerService.delete(answer);
        return answerDtoAssembler.toDto(answer);
    }
}
