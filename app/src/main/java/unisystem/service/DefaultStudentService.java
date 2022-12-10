package unisystem.service;

import org.springframework.stereotype.Service;
import unisystem.domain.Domain;
import unisystem.domain.Entitlements;
import unisystem.domain.Student;
import unisystem.reader.console.DefaultDomainConsoleReader;
import unisystem.reader.console.DomainConsoleReader;
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
    private final DomainConsoleReader domainConsoleReader;
    private StudentSearchService studentSearchService;
    private SearchView searchView = new CLISearchView();
    private UserService userService;

    public DefaultStudentService(CentralRepository centralRepository) {
        this.centralRepository = centralRepository;
        this.domainConsoleReader = new DefaultDomainConsoleReader(centralRepository);
        this.studentSearchService = new DefaultStudentSearchService(centralRepository);
        this.userService = new DefaultUserService(centralRepository);
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
        Student newStudent = domainConsoleReader.readStudentEntryData();

        newStudent.setId(this.centralRepository.getStudentRepository().findAll().size());

        System.out.println("Added student: " + newStudent.toString());

        this.userService.addUser(newStudent.getEmail(), Entitlements.USER);

        this.centralRepository.getStudentRepository().save(newStudent);
    }


    @Override
    public void deleteStudent() {
        long idToDelete = domainConsoleReader.readDomainIdToDelete(this.centralRepository.getStudentRepository().findAll().size());

        System.out.println("Deleted student: " + this.centralRepository.getStudentRepository().findAll().get((int) idToDelete).toString());

        this.userService.deleteUser(this.centralRepository.getStudentRepository().findAll().get((int) idToDelete).getEmail());

        this.centralRepository.getStudentRepository().deleteById(idToDelete);
    }

    @Override
    public void searchStudent(int option) {
        List<Domain> searchedStudents = null;
        if(option == 1) { // by id
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
