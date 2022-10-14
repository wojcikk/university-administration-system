package unisystem.service.search;

import unisystem.domain.Student;

import java.util.List;

public interface SearchView {
    void printSearchedElement(Student searchedStudent);
    void printSearchedList(List<Student> searchedStudents);
}
