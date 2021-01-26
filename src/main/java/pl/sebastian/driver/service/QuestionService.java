package pl.sebastian.driver.service;

import org.springframework.stereotype.Service;
import pl.sebastian.driver.domain.Question;
import pl.sebastian.driver.repository.QuestionRepository;

import java.util.List;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question findById(Long id){
        return questionRepository.findById(id).get();
    }

    public Question save(Question question){
        return questionRepository.save(question);
    }

    public List<Question> all(){
        return questionRepository.findAll();
    }

    public void delete(Question question){
        questionRepository.delete(question);
    }
}
