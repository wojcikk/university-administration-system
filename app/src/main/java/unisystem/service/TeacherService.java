package unisystem.service;

public interface TeacherService {
    void listAllTeachers();
    void addTeacher();
    void deleteTeacher();
    void editTeacher(int option);
    void searchTeacher(int option);
}
