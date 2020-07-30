package pl.sebastian.driver.domain;

import javax.persistence.*;

@Entity
@Table(name = "answers")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
//    @OneToOne
//    @JoinColumn(name = "file_id", unique = true)
//    private File file;
    @Column(name = "file_id", insertable = false, updatable = false)
    private long fileId;


    public Answer() {
    }

    public Answer(Long id, String content, File file, long fileId) {
        this.id = id;
        this.content = content;
        //this.file = file;
        this.fileId = fileId;
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

    public long getFileId() {
        return fileId;
    }

    public void setFileId(long fileId) {
        this.fileId = fileId;
    }
}
