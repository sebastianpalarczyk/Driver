package pl.sebastian.driver.service;

import org.springframework.stereotype.Service;
import pl.sebastian.driver.repository.QuestionRepository;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }
}
