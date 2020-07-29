package pl.sebastian.driver.service;

import org.springframework.stereotype.Service;
import pl.sebastian.driver.domain.Advice;
import pl.sebastian.driver.domain.Question;
import pl.sebastian.driver.repository.QuestionRepository;

import java.util.Optional;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question getQuestionById(Long id) {
        return questionRepository.getOne(id);
    }

    public Question findById(Long id){
        return questionRepository.findById(id).get();
    }

    public Question question(Question question){
        return questionRepository.save(question);
    }

    public Question create(){
        Question question = new Question();
        question.setContent("Najlepsze pytanie");
        return question;
    }

    public Question save(Question question){
        return questionRepository.save(question);
    }
}
