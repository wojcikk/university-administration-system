package unisystem.service;

import unisystem.domain.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudents();
    void listAllStudents();
    void addStudent();
    void deleteStudent();
    void editStudent(int option);
    void searchStudent(int option);
}
