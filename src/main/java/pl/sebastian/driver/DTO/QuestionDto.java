package pl.sebastian.driver.DTO;

import java.util.List;

public class QuestionDto {

    private Long id;
    private String content;
    private String file = "http://localhost:8080/file/{id}";
    private List<AnswerDto> answers;


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

    public String getFile() {
        return file;
    }

    public List<AnswerDto> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerDto> answers) {
        this.answers = answers;
    }
}
