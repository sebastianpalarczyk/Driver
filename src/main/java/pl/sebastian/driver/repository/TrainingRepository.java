package pl.sebastian.driver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sebastian.driver.domain.Training;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Long> {
}
