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
//    @OneToOne
//    @JoinColumn(name = "file_id", unique = true)
//    private File file;
    @Column(name = "file_id", insertable = false, updatable = false)
    private long fileId;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "question_answers",
               joinColumns = @JoinColumn(name = "question_id"),
               inverseJoinColumns = @JoinColumn(name = "answer_id"))
    private List <Answer> answers = new ArrayList<>();

    public Question() {
    }

    public Question(Long id, String content, File file, long fileId, List<Answer> answers) {
        this.id = id;
        this.content = content;
        //this.file = file;
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

//    public File getFile() {
//        return file;
//    }
//
//    public void setFile(File file) {
//        this.file = file;
//    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public long getFileId() {
        return fileId;
    }

    public void setFileId(long fileId) {
        this.fileId = fileId;
    }
}
