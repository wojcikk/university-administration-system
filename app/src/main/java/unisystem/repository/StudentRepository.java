package unisystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unisystem.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
