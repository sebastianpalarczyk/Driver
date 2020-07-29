package pl.sebastian.driver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import pl.sebastian.driver.domain.Advice;
import pl.sebastian.driver.service.AdviceService;

@Controller
public class AdviceController {

    private final AdviceService adviceService;

    public AdviceController(AdviceService adviceService) {
        this.adviceService = adviceService;
    }

    @PostMapping(value = "/advice")
    public Advice create(){
       Advice advice = adviceService.create();
       return adviceService.save(advice);
    }

    @GetMapping(value = "/advice/{id}")
    public Advice one(@PathVariable Long id){
        return adviceService.getAdviceById(id);
    }

    @PutMapping(value = "/advice/{id}")
    public Advice replaceAdvice(@PathVariable Long id){
        Advice advice = adviceService.findById(id);
        Advice replaceAdvice = adviceService.replace(advice);
        return adviceService.save(replaceAdvice);
    }

}
