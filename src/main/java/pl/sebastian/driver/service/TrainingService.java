package pl.sebastian.driver.service;

import org.springframework.stereotype.Service;
import pl.sebastian.driver.domain.Training;
import pl.sebastian.driver.repository.TrainingRepository;

import java.util.List;

@Service
public class TrainingService {

    private final TrainingRepository trainingRepository;

    public TrainingService(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    public Training findById(Long id){
        return trainingRepository.findById(id).get();
    }

    public Training save(Training training){
        return trainingRepository.save(training);
    }

    public List<Training> all(){
        return trainingRepository.findAll();
    }

    public void delete(Training training){
        trainingRepository.delete(training);
    }

}
