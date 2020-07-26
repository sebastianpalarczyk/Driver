package pl.sebastian.driver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sebastian.driver.domain.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}
