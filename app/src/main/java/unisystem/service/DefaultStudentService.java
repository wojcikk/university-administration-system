package unisystem.service;

import unisystem.data.DataStore;
import unisystem.domain.Student;
import unisystem.reader.DefaultStudentConsoleReader;
import unisystem.reader.StudentConsoleReader;
import unisystem.service.search.CLISearchView;
import unisystem.service.search.DefaultStudentSearchService;
import unisystem.service.search.SearchView;
import unisystem.service.search.StudentSearchService;

import java.util.List;

public class DefaultStudentService implements StudentService {
    private final DataStore dataStore;
    private static final StudentConsoleReader studentConsoleReader = new DefaultStudentConsoleReader();
    private StudentSearchService studentSearchService;
    private SearchView searchView = new CLISearchView();

    public DefaultStudentService(DataStore dataStore) {
        this.dataStore = dataStore;
        this.studentSearchService = new DefaultStudentSearchService(this.dataStore);
    }

    @Override
    public void addStudent() {
        Student newStudent = studentConsoleReader.readStudentEntryData();

        newStudent.setId(dataStore.getStudents().size());

        System.out.println("Added student: " + newStudent.toString());

        this.dataStore.getStudents().add(newStudent);
    }

    @Override
    public void deleteStudent() {
        long idToDelete = studentConsoleReader.readStudentIdToDelete(dataStore.getStudents());

        System.out.println("Deleted student: " + this.dataStore.getStudents().get((int) idToDelete).toString());

        this.dataStore.getStudents().remove((int) idToDelete);
    }

    @Override
    public void searchStudent(int option) {
        if(option == 1) {
            Student searchedStudent = studentSearchService.searchStudentById();

            searchView.printSearchedElement(searchedStudent);
        } else if(option == 2) {
            List<Student> searchedStudents = studentSearchService.searchStudentByName();

            searchView.printSearchedList(searchedStudents);
        } else if(option == 3) {
            List<Student> searchedStudents = studentSearchService.searchStudentBySurname();

            searchView.printSearchedList(searchedStudents);
        } else if(option == 4) {
            List<Student> searchedStudents = studentSearchService.searchStudentByGender();

            searchView.printSearchedList(searchedStudents);
        }

    }
}
