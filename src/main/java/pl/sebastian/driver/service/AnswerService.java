package pl.sebastian.driver.service;

import org.springframework.stereotype.Service;
import pl.sebastian.driver.domain.Advice;
import pl.sebastian.driver.domain.Answer;
import pl.sebastian.driver.repository.AnswerRepository;

import java.util.Optional;

@Service
public class AnswerService {

    private final AnswerRepository answerRepository;

    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public Answer getAnswerById(Long id) {
        return answerRepository.getOne(id);
    }

    public Answer save(Answer answer){
        return answerRepository.save(answer);
    }

    public Answer findById(Long id){
        Optional<Answer> findAdvice = answerRepository.findById(id);
        return findAdvice.get();
    }

    public Answer create(){
        Answer answer = new Answer();
        answer.setId(1L);
        answer.setContent("Dobra odpowiedz");
        return answer;
    }
}
