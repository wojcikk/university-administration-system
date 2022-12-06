package unisystem.service;

import org.springframework.stereotype.Service;
import unisystem.data.DataStore;
import unisystem.domain.Student;
import unisystem.reader.console.DefaultStudentConsoleReader;
import unisystem.reader.console.StudentConsoleReader;
import unisystem.repository.MajorRepository;
import unisystem.repository.StudentRepository;
import unisystem.service.search.CLISearchView;
import unisystem.service.search.DefaultStudentSearchService;
import unisystem.service.search.SearchView;
import unisystem.service.search.StudentSearchService;

import java.util.List;

@Service
public class DefaultStudentService implements StudentService {
    private final StudentRepository studentRepository;
    private final MajorRepository majorRepository;
    private final StudentConsoleReader studentConsoleReader;
    private StudentSearchService studentSearchService;
    private SearchView searchView = new CLISearchView();
    private final DataStore dataStore;

    public DefaultStudentService(StudentRepository studentRepository, MajorRepository majorRepository, DataStore dataStore) {
        this.studentRepository = studentRepository;
        this.majorRepository = majorRepository;
        this.dataStore = dataStore;
        this.studentConsoleReader = new DefaultStudentConsoleReader(studentRepository, majorRepository, dataStore);
        this.studentSearchService = new DefaultStudentSearchService(studentRepository, majorRepository, dataStore);
    }

    @Override
    public void listAllStudents() {
        System.out.printf("%-5s %-20s %-20s %-10s %-10s %-30s %-30s %-20s %-40s\n",
                "ID", "NAME", "SURNAME", "GENDER", "AGE", "EMAIL", "FIELD OF STUDY", "DEGREE", "FACULTY"
        );

        studentRepository.findAll().forEach(student -> {
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

        newStudent.setId(studentRepository.findAll().size());

        System.out.println("Added student: " + newStudent.toString());

        this.studentRepository.save(newStudent);
    }


    @Override
    public void deleteStudent() {
        long idToDelete = studentConsoleReader.readStudentIdToDelete(this.studentRepository.findAll());

        System.out.println("Deleted student: " + this.studentRepository.findAll().get((int) idToDelete).toString());

        //this.studentRepository.findAll().remove((int) idToDelete);
        this.studentRepository.delete(this.studentRepository.getById(idToDelete));
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
