package unisystem.service;

import org.springframework.stereotype.Service;
import unisystem.domain.Domain;
import unisystem.domain.Student;
import unisystem.reader.console.DefaultStudentConsoleReader;
import unisystem.reader.console.StudentConsoleReader;
import unisystem.repository.CentralRepository;
import unisystem.service.search.CLISearchView;
import unisystem.service.search.DefaultStudentSearchService;
import unisystem.service.search.SearchView;
import unisystem.service.search.StudentSearchService;

import java.util.Collections;
import java.util.List;

@Service
public class DefaultStudentService implements StudentService {
    private final CentralRepository centralRepository;
    private final StudentConsoleReader studentConsoleReader;
    private StudentSearchService studentSearchService;
    private SearchView searchView = new CLISearchView();

    public DefaultStudentService(CentralRepository centralRepository) {
        this.centralRepository = centralRepository;
        this.studentConsoleReader = new DefaultStudentConsoleReader(centralRepository);
        this.studentSearchService = new DefaultStudentSearchService(centralRepository);
    }

    @Override
    public void listAllStudents() {
        System.out.printf("%-5s %-20s %-20s %-10s %-10s %-30s %-30s %-20s %-40s\n",
                "ID", "NAME", "SURNAME", "GENDER", "AGE", "EMAIL", "FIELD OF STUDY", "DEGREE", "FACULTY"
        );

        this.centralRepository.getStudentRepository().findAll().forEach(student -> {
            System.out.printf("%-5s %-20s %-20s %-10s %-10s %-30s %-30s %-20s %-40s\n",
                    student.getId(),
                    student.getName(),
                    student.getSurname(),
                    student.getGender(),
                    student.getAge(),
                    student.getEmail(),
                    student.getMajor().getFieldOfStudy().getName(),
                    student.getMajor().getDegree().getName(),
                    student.getMajor().getFaculty().getName());
        });
    }


    @Override
    public void addStudent() {
        Student newStudent = studentConsoleReader.readStudentEntryData();

        newStudent.setId(this.centralRepository.getStudentRepository().findAll().size());

        System.out.println("Added student: " + newStudent.toString());

        this.centralRepository.getStudentRepository().save(newStudent);
    }


    @Override
    public void deleteStudent() {
        long idToDelete = studentConsoleReader.readStudentIdToDelete(this.centralRepository.getStudentRepository().findAll());

        System.out.println("Deleted student: " + this.centralRepository.getStudentRepository().findAll().get((int) idToDelete).toString());

        this.centralRepository.getStudentRepository().deleteById(idToDelete);
    }

    @Override
    public void searchStudent(int option) {
        List<Domain> searchedStudents = null;
        if(option == 1) {
            searchedStudents = Collections.singletonList(studentSearchService.searchStudentById());
        } else if(option == 2) {
            searchedStudents = studentSearchService.searchStudentByName();
        } else if(option == 3) {
            searchedStudents = studentSearchService.searchStudentBySurname();
        } else if(option == 4) {
            searchedStudents = studentSearchService.searchStudentByGender();
        } else if(option == 5) {
            searchedStudents = studentSearchService.searchStudentByAge();
        } else if(option == 6) {
            searchedStudents = studentSearchService.searchStudentByEmail();

        }
        searchView.printSearchedList(searchedStudents);

    }
}
