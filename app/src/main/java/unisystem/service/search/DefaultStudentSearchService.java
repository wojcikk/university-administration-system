package unisystem.service.search;

import org.springframework.stereotype.Service;
import unisystem.domain.Domain;
import unisystem.domain.Student;
import unisystem.reader.console.DefaultDomainConsoleReader;
import unisystem.reader.console.DomainConsoleReader;
import unisystem.repository.CentralRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultStudentSearchService implements StudentSearchService {
    private final CentralRepository centralRepository;
    private final DomainConsoleReader domainConsoleReader;

    public DefaultStudentSearchService(CentralRepository centralRepository) {
        this.centralRepository = centralRepository;
        this.domainConsoleReader = new DefaultDomainConsoleReader(centralRepository);
    }

    @Override
    public Domain searchStudentById() {
        long id = domainConsoleReader.readDomainId();

        for(Student student : this.centralRepository.getStudentRepository().findAll()) {
           if(student.getId() == id) {
               return student;
           }
        }

        return null;
    }

    @Override
    public List<Domain> searchStudentByName() {
        String name = domainConsoleReader.readDomainName();
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
        String surname = domainConsoleReader.readDomainSurname();
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
        String gender = domainConsoleReader.readDomainGender();
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
        long age = domainConsoleReader.readDomainAge();
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
        String email = domainConsoleReader.readDomainEmail();
        List<Domain> searchedStudents = new ArrayList<>();

        for(Student student : this.centralRepository.getStudentRepository().findAll()) {
            if(student.getGender().equalsIgnoreCase(email)) {
                searchedStudents.add(student);
            }
        }

        return searchedStudents;
    }
}
