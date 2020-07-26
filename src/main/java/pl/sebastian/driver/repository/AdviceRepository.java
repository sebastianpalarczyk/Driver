package pl.sebastian.driver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sebastian.driver.domain.Advice;

@Repository
public interface AdviceRepository extends JpaRepository<Advice, Long> {
}
