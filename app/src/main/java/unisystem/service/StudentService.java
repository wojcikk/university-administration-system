package unisystem.service;

import unisystem.domain.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudents();
    Student addStudent(Student student);
    Student findStudentById(Long studentId);
    Student updateStudent(Long studentId, Student newStudent);
    void deleteStudentById(Long studentId);
    void listAllStudents();
    void addStudent();
    void deleteStudent();
    void editStudent(int option);
    void searchStudent(int option);
}
