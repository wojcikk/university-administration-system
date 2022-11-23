package unisystem.service.search;

import unisystem.domain.Student;
import unisystem.domain.Teacher;

import java.util.List;

public interface SearchView {
    void printSearchedStudentElement(Student searchedStudent);
    void printSearchedStudentList(List<Student> searchedStudent);
    void printSearchedTeacherElement(Teacher searchedTeacher);
    void printSearchedTeacherList(List<Teacher> searchedTeachers);
}
