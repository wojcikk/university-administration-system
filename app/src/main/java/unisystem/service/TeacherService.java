package unisystem.service;

import unisystem.domain.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> getTeachers();
    void listAllTeachers();
    void addTeacher();
    void deleteTeacher();
    void editTeacher(int option);
    void searchTeacher(int option);
}
