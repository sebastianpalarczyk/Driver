package pl.sebastian.driver.DTO;


public class AnswerDto {

    private Long id;
    private String content;
    private String fileId;// = "http://localhost:8080/file/{id}";

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

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }
}
