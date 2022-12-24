package unisystem.service.edit;

import unisystem.domain.Student;

public interface StudentEditService {
    void editStudent(Student student);
    void editStudentName(Student student);
    void editStudentSurname(Student student);
    void editStudentGender(Student student);
    void editStudentAge(Student student);
    void editStudentMajor(Student student);
}
