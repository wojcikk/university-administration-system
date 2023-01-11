package unisystem.service;

import unisystem.domain.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> getTeachers();
    Teacher addTeacher(Teacher newTeacher);
    Teacher findTeacherById(Long teacherId);
    Teacher updateTeacher(Long teacherId, Teacher newTeacher);
    void deleteTeacherById(Long teacherId);
    void listAllTeachers();
    void addTeacher();
    void deleteTeacher();
    void editTeacher(int option);
    void searchTeacher(int option);
}
