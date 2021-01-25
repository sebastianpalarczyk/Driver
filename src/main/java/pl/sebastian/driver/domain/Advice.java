package pl.sebastian.driver.domain;

import javax.persistence.*;

@Entity
@Table(name = "advices")
public class Advice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
//    @OneToOne
//    @JoinColumn(name = "file_id", unique = true)
//    private File file;
    @Column(name = "file_id")
    private Long fileId;



    public Advice() {
    }

    public Advice(Long id, String content, File file, Long fileId) {
        this.id = id;
        this.content = content;
//        this.file = file;
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

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }
}
