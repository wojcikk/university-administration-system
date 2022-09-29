package unisystem.data;

import unisystem.domain.Student;

import java.util.List;

public interface DataStore {
    void init();
    List<Student> readStudents();
    List<Student> getStudents();
}
