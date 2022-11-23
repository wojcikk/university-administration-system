package unisystem.service.search;

import unisystem.domain.Student;
import unisystem.domain.Teacher;

import java.util.List;

public class CLISearchView implements SearchView {

    @Override
    public void printSearchedStudentElement(Student searchedStudent) {
        if(searchedStudent != null) {
            System.out.println("\nSearching completed:\n" + searchedStudent);
        } else {
            System.out.println("\nSearching completed:\nstudent do not exist");
        }
    }

    @Override
    public void printSearchedStudentList(List<Student> searchedStudent) {
        if(!searchedStudent.isEmpty()) {
            System.out.println("\nSearching completed:");
            searchedStudent.stream().forEach(System.out::println);
        } else {
            System.out.println("\nSearching completed:\nstudent do not exist");
        }
    }

    @Override
    public void printSearchedTeacherElement(Teacher searchedTeacher) {
        if(searchedTeacher != null) {
            System.out.println("\nSearching completed:\n" + searchedTeacher);
        } else {
            System.out.println("\nSearching completed:\nteacher do not exist");
        }
    }

    @Override
    public void printSearchedTeacherList(List<Teacher> searchedTeachers) {
        if(!searchedTeachers.isEmpty()) {
            System.out.println("\nSearching completed:");
            searchedTeachers.stream().forEach(System.out::println);
        } else {
            System.out.println("\nSearching completed:\nteacher do not exist");
        }
    }
}
