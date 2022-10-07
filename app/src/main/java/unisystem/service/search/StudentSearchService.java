package unisystem.service.search;

import unisystem.domain.Student;

import java.util.List;

public interface StudentSearchService {
    Student searchStudentById();
    List<Student> searchStudentByName();
    List<Student> searchStudentBySurname();
    List<Student> searchStudentByGender();
    List<Student> searchStudentByAge();
    List<Student> searchStudentByEmail();
}
