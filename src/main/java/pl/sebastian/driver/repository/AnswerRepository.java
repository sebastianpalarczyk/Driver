package pl.sebastian.driver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sebastian.driver.domain.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
