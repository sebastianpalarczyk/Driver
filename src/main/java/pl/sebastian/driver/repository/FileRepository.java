package pl.sebastian.driver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sebastian.driver.domain.File;

@Repository
public interface FileRepository extends JpaRepository<File, String> {
}
