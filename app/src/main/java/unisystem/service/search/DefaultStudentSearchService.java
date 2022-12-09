package unisystem.service.search;

import org.springframework.stereotype.Service;
import unisystem.domain.Domain;
import unisystem.domain.Student;
import unisystem.reader.console.DefaultStudentConsoleReader;
import unisystem.reader.console.StudentConsoleReader;
import unisystem.repository.CentralRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultStudentSearchService implements StudentSearchService {
    private final CentralRepository centralRepository;
    private final StudentConsoleReader studentConsoleReader;

    public DefaultStudentSearchService(CentralRepository centralRepository) {
        this.centralRepository = centralRepository;
        this.studentConsoleReader = new DefaultStudentConsoleReader(centralRepository);
    }

    @Override
    public Domain searchStudentById() {
        long id = studentConsoleReader.readStudentId();

        for(Student student : this.centralRepository.getStudentRepository().findAll()) {
           if(student.getId() == id) {
               return student;
           }
        }

        return null;
    }

    @Override
    public List<Domain> searchStudentByName() {
        String name = studentConsoleReader.readStudentName();
        List<Domain> searchedStudents = new ArrayList<>();

        for(Student student : this.centralRepository.getStudentRepository().findAll()) {
            if(student.getName().equalsIgnoreCase(name)) {
                searchedStudents.add(student);
            }
        }

        return searchedStudents;
    }

    @Override
    public List<Domain> searchStudentBySurname() {
        String surname = studentConsoleReader.readStudentSurname();
        List<Domain> searchedStudents = new ArrayList<>();

        for(Student student : this.centralRepository.getStudentRepository().findAll()) {
            if(student.getSurname().equalsIgnoreCase(surname)) {
                searchedStudents.add(student);
            }
        }

        return searchedStudents;
    }

    @Override
    public List<Domain> searchStudentByGender() {
        String gender = studentConsoleReader.readStudentGender();
        List<Domain> searchedStudents = new ArrayList<>();

        for(Student student : this.centralRepository.getStudentRepository().findAll()) {
            if(student.getGender().equalsIgnoreCase(gender)) {
                searchedStudents.add(student);
            }
        }

        return searchedStudents;
    }

    @Override
    public List<Domain> searchStudentByAge() {
        long age = studentConsoleReader.readStudentAge();
        List<Domain> searchedStudents = new ArrayList<>();

        for(Student student : this.centralRepository.getStudentRepository().findAll()) {
            if(student.getAge() == age) {
                searchedStudents.add(student);
            }
        }

        return searchedStudents;
    }

    @Override
    public List<Domain> searchStudentByEmail() {
        String email = studentConsoleReader.readStudentEmail();
        List<Domain> searchedStudents = new ArrayList<>();

        for(Student student : this.centralRepository.getStudentRepository().findAll()) {
            if(student.getGender().equalsIgnoreCase(email)) {
                searchedStudents.add(student);
            }
        }

        return searchedStudents;
    }
}
