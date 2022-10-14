package unisystem.service.search;

import unisystem.data.DataStore;
import unisystem.domain.Student;
import unisystem.reader.DefaultStudentConsoleReader;
import unisystem.reader.StudentConsoleReader;

import java.util.ArrayList;
import java.util.List;

public class DefaultStudentSearchService implements StudentSearchService {
    private final DataStore dataStore;
    private static final StudentConsoleReader studentConsoleReader = new DefaultStudentConsoleReader();

    public DefaultStudentSearchService(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public Student searchStudentById() {
        long id = studentConsoleReader.readStudentId();

        for(Student student : dataStore.getStudents()) {
           if(student.getId() == id) {
               return student;
           }
        }

        return null;
    }

    @Override
    public List<Student> searchStudentByName() {
        String name = studentConsoleReader.readStudentName();
        List<Student> searchedStudents = new ArrayList<>();

        for(Student student : dataStore.getStudents()) {
            if(student.getName().equalsIgnoreCase(name)) {
                searchedStudents.add(student);
            }
        }

        return searchedStudents;
    }

    @Override
    public List<Student> searchStudentBySurname() {
        String surname = studentConsoleReader.readStudentSurname();
        List<Student> searchedStudents = new ArrayList<>();

        for(Student student : dataStore.getStudents()) {
            if(student.getSurname().equalsIgnoreCase(surname)) {
                searchedStudents.add(student);
            }
        }

        return searchedStudents;
    }

    @Override
    public List<Student> searchStudentByGender() {
        String gender = studentConsoleReader.readStudentGender();
        List<Student> searchedStudents = new ArrayList<>();

        for(Student student : dataStore.getStudents()) {
            if(student.getGender().equalsIgnoreCase(gender)) {
                searchedStudents.add(student);
            }
        }

        return searchedStudents;
    }

    @Override
    public List<Student> searchStudentByAge() {
        return null;
    }

    @Override
    public List<Student> searchStudentByEmail() {
        return null;
    }
}
