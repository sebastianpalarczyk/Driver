package pl.sebastian.driver.DTO;

public class AnswerDto {

    private Long id;
    private String content;
    private String file = "http://localhost:8080/file/{id}";

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
}
