package unisystem.service.search;

import org.springframework.stereotype.Service;
import unisystem.domain.Domain;
import unisystem.domain.Teacher;
import unisystem.reader.console.DefaultTeacherConsoleReader;
import unisystem.reader.console.TeacherConsoleReader;
import unisystem.repository.CentralRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultTeacherSearchService implements TeacherSearchService {
    private final CentralRepository centralRepository;
    private final TeacherConsoleReader teacherConsoleReader;

    public DefaultTeacherSearchService(CentralRepository centralRepository) {
        this.centralRepository = centralRepository;
        this.teacherConsoleReader = new DefaultTeacherConsoleReader(centralRepository);
    }

    @Override
    public Domain searchTeacherById() {
        long id = teacherConsoleReader.readTeacherId();

        for(Teacher teacher : this.centralRepository.getTeacherRepository().findAll()) {
            if(teacher.getId() == id) {
                return teacher;
            }
        }

        return null;
    }

    @Override
    public List<Domain> searchTeacherByName() {
        String name = teacherConsoleReader.readTeacherName();
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
        String surname = teacherConsoleReader.readTeacherSurname();
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
        String gender = teacherConsoleReader.readTeacherGender();
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
        long age = teacherConsoleReader.readTeacherAge();
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
        String email = teacherConsoleReader.readTeacherEmail();
        List<Domain> searchedTeachers = new ArrayList<>();

        for(Teacher teacher : this.centralRepository.getTeacherRepository().findAll()) {
            if(teacher.getGender().equalsIgnoreCase(email)) {
                searchedTeachers.add(teacher);
            }
        }

        return searchedTeachers;
    }
}
