package unisystem.service.search;

import unisystem.data.DataStore;
import unisystem.domain.Teacher;
import unisystem.reader.console.DefaultTeacherConsoleReader;
import unisystem.reader.console.TeacherConsoleReader;

import java.util.ArrayList;
import java.util.List;

public class DefaultTeacherSearchService implements TeacherSearchService {
    private final DataStore dataStore;
    private final TeacherConsoleReader teacherConsoleReader;

    public DefaultTeacherSearchService(DataStore dataStore) {
        this.dataStore = dataStore;
        this.teacherConsoleReader = new DefaultTeacherConsoleReader(dataStore);
    }

    @Override
    public Teacher searchTeacherById() {
        long id = teacherConsoleReader.readTeacherId();

        for(Teacher teacher : dataStore.getTeachers()) {
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

        for(Teacher teacher : dataStore.getTeachers()) {
            if(teacher.getPerson().getName().equalsIgnoreCase(name)) {
                searchedTeachers.add(teacher);
            }
        }

        return searchedTeachers;
    }

    @Override
    public List<Teacher> searchTeacherBySurname() {
        return null;
    }

    @Override
    public List<Teacher> searchTeacherByGender() {
        return null;
    }

    @Override
    public List<Teacher> searchTeacherByAge() {
        return null;
    }

    @Override
    public List<Teacher> searchTeacherByEmail() {
        return null;
    }
}
