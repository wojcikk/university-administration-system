package unisystem.service;

public interface StudentService {
    void listAllStudents();
    void addStudent();
    void deleteStudent();
    void editStudent(int option);
    void searchStudent(int option);
}
