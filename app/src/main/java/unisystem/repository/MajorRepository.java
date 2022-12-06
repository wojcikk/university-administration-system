package unisystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unisystem.domain.Major;

public interface MajorRepository extends JpaRepository<Major, Long> {
}
