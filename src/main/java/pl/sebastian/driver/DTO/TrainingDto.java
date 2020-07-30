package pl.sebastian.driver.DTO;

import pl.sebastian.driver.domain.Question;

import java.util.ArrayList;
import java.util.List;

public class TrainingDto {

    private Long id;
    private String content;
    private List<QuestionDto> questions = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<QuestionDto> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDto> questions) {
        this.questions = questions;
    }
}
