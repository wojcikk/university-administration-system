package unisystem.service.search;

import unisystem.domain.Student;

import java.util.List;

public class CLISearchView implements SearchView {
    @Override
    public void printSearchedElement(Student searchedStudent) {
        if(searchedStudent != null) {
            System.out.println("\nSearching completed:\n" + searchedStudent);
        } else {
            System.out.println("\nSearching completed:\nstudent do not exist");
        }
    }

    @Override
    public void printSearchedList(List<Student> searchedStudents) {
        if(!searchedStudents.isEmpty()) {
            System.out.println("\nSearching completed:");
            searchedStudents.stream().forEach(System.out::println);
        } else {
            System.out.println("\nSearching completed:\nstudent do not exist");
        }
    }
}
