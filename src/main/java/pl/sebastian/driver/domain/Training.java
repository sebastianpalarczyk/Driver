package pl.sebastian.driver.domain;

import javax.persistence.*;

@Entity
@Table(name = "tranings")
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}