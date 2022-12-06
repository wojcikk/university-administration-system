package unisystem.repository;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class DefaultCentralRepository implements CentralRepository {
    private final StudentRepository studentRepository;
    private final MajorRepository majorRepository;
    private final DegreeRepository degreeRepository;
    private final FacultyRepository facultyRepository;
    private final FieldOfStudyRepository fieldOfStudyRepository;
    private final TeacherRepository teacherRepository;
    private final UserRepository userRepository;
}
