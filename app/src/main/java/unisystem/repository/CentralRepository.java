package unisystem.repository;

public interface CentralRepository {
    StudentRepository getStudentRepository();
    MajorRepository getMajorRepository();
    DegreeRepository getDegreeRepository();
    FacultyRepository getFacultyRepository();
    FieldOfStudyRepository getFieldOfStudyRepository();
    TeacherRepository getTeacherRepository();
    UserRepository getUserRepository();
}
