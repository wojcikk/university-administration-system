package unisystem.service.search;

import unisystem.data.DataStore;
import unisystem.domain.Student;
import unisystem.reader.DefaultStudentConsoleReader;
import unisystem.reader.StudentConsoleReader;

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
               System.out.println("Searching completed: " + student);
               return student;
           }
        }

        System.out.println("Searching completed: student do not exist");

        return null;
    }

    @Override
    public List<Student> searchStudentByName() {
        return null;
    }

    @Override
    public List<Student> searchStudentBySurname() {
        return null;
    }

    @Override
    public List<Student> searchStudentByGender() {
        return null;
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
