package unisystem.service;

import org.springframework.stereotype.Service;
import unisystem.domain.Student;
import unisystem.reader.console.DefaultStudentConsoleReader;
import unisystem.reader.console.StudentConsoleReader;
import unisystem.repository.CentralRepository;
import unisystem.service.search.CLISearchView;
import unisystem.service.search.DefaultStudentSearchService;
import unisystem.service.search.SearchView;
import unisystem.service.search.StudentSearchService;

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
        if(option == 1) {
            Student searchedStudent = studentSearchService.searchStudentById();

            searchView.printSearchedStudentElement(searchedStudent);
        } else if(option == 2) {
            List<Student> searchedStudents = studentSearchService.searchStudentByName();

            searchView.printSearchedStudentList(searchedStudents);
        } else if(option == 3) {
            List<Student> searchedStudents = studentSearchService.searchStudentBySurname();

            searchView.printSearchedStudentList(searchedStudents);
        } else if(option == 4) {
            List<Student> searchedStudents = studentSearchService.searchStudentByGender();

            searchView.printSearchedStudentList(searchedStudents);
        } else if(option == 5) {
            List<Student> searchedStudents = studentSearchService.searchStudentByAge();

            searchView.printSearchedStudentList(searchedStudents);
        } else if(option == 6) {
            List<Student> searchedStudents = studentSearchService.searchStudentByEmail();

            searchView.printSearchedStudentList(searchedStudents);
        }

    }
}
