package unisystem.service.search;

import org.springframework.stereotype.Service;
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
    public Teacher searchTeacherById() {
        long id = teacherConsoleReader.readTeacherId();

        for(Teacher teacher : this.centralRepository.getTeacherRepository().findAll()) {
            if(teacher.getId() == id) {
                return teacher;
            }
        }

        return null;
    }

    @Override
    public List<Teacher> searchTeacherByName() {
        String name = teacherConsoleReader.readTeacherName();
        List<Teacher> searchedTeachers = new ArrayList<>();

        for(Teacher teacher : this.centralRepository.getTeacherRepository().findAll()) {
            if(teacher.getName().equalsIgnoreCase(name)) {
                searchedTeachers.add(teacher);
            }
        }

        return searchedTeachers;
    }

    @Override
    public List<Teacher> searchTeacherBySurname() {
        String surname = teacherConsoleReader.readTeacherSurname();
        List<Teacher> searchedTeacher = new ArrayList<>();

        for(Teacher teacher : this.centralRepository.getTeacherRepository().findAll()) {
            if(teacher.getSurname().equalsIgnoreCase(surname)) {
                searchedTeacher.add(teacher);
            }
        }

        return searchedTeacher;
    }

    @Override
    public List<Teacher> searchTeacherByGender() {
        String gender = teacherConsoleReader.readTeacherGender();
        List<Teacher> searchedTeachers = new ArrayList<>();

        for(Teacher teacher : this.centralRepository.getTeacherRepository().findAll()) {
            if(teacher.getGender().equalsIgnoreCase(gender)) {
                searchedTeachers.add(teacher);
            }
        }

        return searchedTeachers;
    }

    @Override
    public List<Teacher> searchTeacherByAge() {
        long age = teacherConsoleReader.readTeacherAge();
        List<Teacher> searchedTeachers = new ArrayList<>();

        for(Teacher teacher : this.centralRepository.getTeacherRepository().findAll()) {
            if(teacher.getAge() == age) {
                searchedTeachers.add(teacher);
            }
        }

        return searchedTeachers;
    }

    @Override
    public List<Teacher> searchTeacherByEmail() {
        String email = teacherConsoleReader.readTeacherEmail();
        List<Teacher> searchedTeachers = new ArrayList<>();

        for(Teacher teacher : this.centralRepository.getTeacherRepository().findAll()) {
            if(teacher.getGender().equalsIgnoreCase(email)) {
                searchedTeachers.add(teacher);
            }
        }

        return searchedTeachers;
    }
}
