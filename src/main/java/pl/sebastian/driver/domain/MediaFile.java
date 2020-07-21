package pl.sebastian.driver.domain;

import javax.persistence.*;

@Entity
@Table(name = "files")
public class MediaFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
