package unisystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unisystem.domain.FieldOfStudy;

public interface FieldOfStudyRepository extends JpaRepository<FieldOfStudy, Long> {
}
