package pl.sebastian.driver.controller;

import org.springframework.web.bind.annotation.*;
import pl.sebastian.driver.DTO.AdviceDto;
import pl.sebastian.driver.assembler.AdviceDtoAssembler;
import pl.sebastian.driver.domain.Advice;
import pl.sebastian.driver.service.AdviceService;

@RestController
public class AdviceController {

    private final AdviceService adviceService;
    private final AdviceDtoAssembler adviceDtoAssembler;

    public AdviceController(AdviceService adviceService, AdviceDtoAssembler adviceDtoAssembler) {
        this.adviceService = adviceService;
        this.adviceDtoAssembler = adviceDtoAssembler;
    }

//    @PostMapping(value = "/advice")
//    public AdviceDto create(@RequestBody AdviceDto adviceDto){
//       Advice advice = adviceDtoAssembler.fromDto(adviceDto);
//       return adviceDtoAssembler.toDto(adviceService.save(advice));
//    }

    @GetMapping(value = "/advice/{id}")
    public AdviceDto one(@PathVariable Long id){
        Advice advice = adviceService.findById(id);
        return adviceDtoAssembler.toDto(advice);
    }

    @PutMapping(value = "/advice/{id}")
    public AdviceDto update(@PathVariable Long id, @RequestBody AdviceDto adviceDto){
        Advice advice = adviceService.getAdviceById(id);
        advice.setContent(adviceDto.getContent());
        advice.setFileId(Long.parseLong(adviceDto.getFile()));
        return adviceDtoAssembler.toDto(adviceService.save(advice));
    }

    @PostMapping(value = "/advice")
    public AdviceDto create(){
       Advice advice = new Advice();
       advice.setContent("content");
       advice.setFileId(12);
       return adviceDtoAssembler.toDto(advice);
    }

}
