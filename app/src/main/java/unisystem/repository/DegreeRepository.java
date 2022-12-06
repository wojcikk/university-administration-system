package unisystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unisystem.domain.Degree;

public interface DegreeRepository extends JpaRepository<Degree, Long> {
}
