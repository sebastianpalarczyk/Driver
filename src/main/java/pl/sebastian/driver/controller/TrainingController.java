package pl.sebastian.driver.controller;

import org.springframework.stereotype.Controller;
import pl.sebastian.driver.service.TrainingService;

@Controller
public class TrainingController {

    private final TrainingService trainingService;

    public TrainingController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }
}
