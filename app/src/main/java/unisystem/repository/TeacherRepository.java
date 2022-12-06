package unisystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unisystem.domain.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
