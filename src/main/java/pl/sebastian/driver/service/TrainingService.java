package pl.sebastian.driver.service;

import org.springframework.stereotype.Service;
import pl.sebastian.driver.domain.Advice;
import pl.sebastian.driver.domain.Training;
import pl.sebastian.driver.repository.TrainingRepository;

@Service
public class TrainingService {

    private final TrainingRepository trainingRepository;

    public TrainingService(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    public Training getTrainingById(Long id) {
        return trainingRepository.getOne(id);
    }

    public Training findById(Long id){
        return trainingRepository.findById(id).get();
    }

    public Training save(Training training){
        return trainingRepository.save(training);
    }

    public Training create(){
        Training training = new Training();
        training.setContent("Dobry trening");
        return trainingRepository.save(training);
    }
}
