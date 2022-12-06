package unisystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unisystem.domain.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
}
