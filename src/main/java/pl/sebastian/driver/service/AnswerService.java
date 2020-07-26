package pl.sebastian.driver.service;

import org.springframework.stereotype.Service;
import pl.sebastian.driver.repository.AnswerRepository;

@Service
public class AnswerService {

    private final AnswerRepository answerRepository;

    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }
}
