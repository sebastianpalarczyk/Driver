package pl.sebastian.driver.domain;

import javax.persistence.*;

@Entity
@Table(name = "counsels")
public class Counsel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
