package pl.sebastian.driver.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    @Column(name = "file_id")
    private Long fileId;
    @Column(name = "traning_id")
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "question_answers",
               joinColumns = @JoinColumn(name = "question_id"),
               inverseJoinColumns = @JoinColumn(name = "answer_id"))
    private List <Answer> answers = new ArrayList<>();

    public Question() {
    }

    public Question(Long id, String content, Long fileId, List<Answer> answers) {
        this.id = id;
        this.content = content;
        this.fileId = fileId;
        this.answers = answers;
    }

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

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
