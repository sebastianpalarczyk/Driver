package pl.sebastian.driver.controller;

import org.springframework.web.bind.annotation.*;
import pl.sebastian.driver.DTO.AdviceDto;
import pl.sebastian.driver.assembler.AdviceDtoAssembler;
import pl.sebastian.driver.domain.Advice;
import pl.sebastian.driver.service.AdviceService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AdviceController {

    private final AdviceService adviceService;
    private final AdviceDtoAssembler adviceDtoAssembler;

    public AdviceController(AdviceService adviceService, AdviceDtoAssembler adviceDtoAssembler) {
        this.adviceService = adviceService;
        this.adviceDtoAssembler = adviceDtoAssembler;
    }

    @PostMapping(value = "/advice")
    public AdviceDto create(@RequestBody AdviceDto adviceDto){
       Advice advice = new Advice();
       advice.setId(adviceDto.getId());
       advice.setContent(adviceDto.getContent());
       advice.setFileId(Long.parseLong(adviceDto.getFileID()));
       return adviceDtoAssembler.toDto(adviceService.save(advice));
    }

    @GetMapping(value = "/advice/{id}")
    public AdviceDto one(@PathVariable Long id){
        Advice advice = adviceService.findById(id);
        return adviceDtoAssembler.toDto(advice);
    }

    @GetMapping(value = "/advice")
    public List<AdviceDto> all(){
        return adviceService.all().stream()
                .map( advice -> adviceDtoAssembler.toDto(advice))
                .collect(Collectors.toList());
    }

    @PutMapping(value = "/advice/{id}")
    public AdviceDto update(@PathVariable Long id, @RequestBody AdviceDto adviceDto){
        Advice advice = adviceService.getAdviceById(id);
        advice.setContent(adviceDto.getContent());
        advice.setFileId(Long.valueOf(adviceDto.getFileID()));
        return adviceDtoAssembler.toDto(adviceService.save(advice));
    }

    @DeleteMapping(value = "/advice/{id}")
    public AdviceDto delete(@PathVariable Long id){
        Advice advice = adviceService.findById(id);
        adviceService.delete(advice);
        return adviceDtoAssembler.toDto(advice);
    }

}
