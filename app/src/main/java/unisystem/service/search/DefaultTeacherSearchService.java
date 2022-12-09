package unisystem.service.search;

import org.springframework.stereotype.Service;
import unisystem.domain.Domain;
import unisystem.domain.Teacher;
import unisystem.reader.console.DefaultDomainConsoleReader;
import unisystem.reader.console.DomainConsoleReader;
import unisystem.repository.CentralRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultTeacherSearchService implements TeacherSearchService {
    private final CentralRepository centralRepository;
    private final DomainConsoleReader domainConsoleReader;

    public DefaultTeacherSearchService(CentralRepository centralRepository) {
        this.centralRepository = centralRepository;
        this.domainConsoleReader = new DefaultDomainConsoleReader(centralRepository);
    }

    @Override
    public Domain searchTeacherById() {
        long id = domainConsoleReader.readDomainId();

        for(Teacher teacher : this.centralRepository.getTeacherRepository().findAll()) {
            if(teacher.getId() == id) {
                return teacher;
            }
        }

        return null;
    }

    @Override
    public List<Domain> searchTeacherByName() {
        String name = domainConsoleReader.readDomainName();
        List<Domain> searchedTeachers = new ArrayList<>();

        for(Teacher teacher : this.centralRepository.getTeacherRepository().findAll()) {
            if(teacher.getName().equalsIgnoreCase(name)) {
                searchedTeachers.add(teacher);
            }
        }

        return searchedTeachers;
    }

    @Override
    public List<Domain> searchTeacherBySurname() {
        String surname = domainConsoleReader.readDomainSurname();
        List<Domain> searchedTeacher = new ArrayList<>();

        for(Teacher teacher : this.centralRepository.getTeacherRepository().findAll()) {
            if(teacher.getSurname().equalsIgnoreCase(surname)) {
                searchedTeacher.add(teacher);
            }
        }

        return searchedTeacher;
    }

    @Override
    public List<Domain> searchTeacherByGender() {
        String gender = domainConsoleReader.readDomainGender();
        List<Domain> searchedTeachers = new ArrayList<>();

        for(Teacher teacher : this.centralRepository.getTeacherRepository().findAll()) {
            if(teacher.getGender().equalsIgnoreCase(gender)) {
                searchedTeachers.add(teacher);
            }
        }

        return searchedTeachers;
    }

    @Override
    public List<Domain> searchTeacherByAge() {
        long age = domainConsoleReader.readDomainAge();
        List<Domain> searchedTeachers = new ArrayList<>();

        for(Teacher teacher : this.centralRepository.getTeacherRepository().findAll()) {
            if(teacher.getAge() == age) {
                searchedTeachers.add(teacher);
            }
        }

        return searchedTeachers;
    }

    @Override
    public List<Domain> searchTeacherByEmail() {
        String email = domainConsoleReader.readDomainEmail();
        List<Domain> searchedTeachers = new ArrayList<>();

        for(Teacher teacher : this.centralRepository.getTeacherRepository().findAll()) {
            if(teacher.getGender().equalsIgnoreCase(email)) {
                searchedTeachers.add(teacher);
            }
        }

        return searchedTeachers;
    }
}
