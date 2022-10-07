package unisystem.service;

import unisystem.data.DataStore;
import unisystem.domain.Student;
import unisystem.reader.DefaultStudentConsoleReader;
import unisystem.reader.StudentConsoleReader;
import unisystem.service.search.DefaultStudentSearchService;
import unisystem.service.search.StudentSearchService;

public class DefaultStudentService implements StudentService {
    private final DataStore dataStore;
    private static final StudentConsoleReader studentConsoleReader = new DefaultStudentConsoleReader();
    private StudentSearchService studentSearchService;

    public DefaultStudentService(DataStore dataStore) {
        this.dataStore = dataStore;
        this.studentSearchService = new DefaultStudentSearchService(this.dataStore);
    }

    @Override
    public void addStudent() {
        Student newStudent = studentConsoleReader.readStudentEntryData();

        newStudent.setId(dataStore.getStudents().size() + (long) 1);

        System.out.println("Added student: " + newStudent.toString());

        this.dataStore.getStudents().add(newStudent);
    }

    @Override
    public void deleteStudent() {
        long idToDelete = studentConsoleReader.readStudentIdToDelete(dataStore.getStudents());

        System.out.println("Deleted student: " + this.dataStore.getStudents().get((int) idToDelete).toString());

        this.dataStore.getStudents().remove((int) idToDelete);
    }

    @Override
    public void searchStudent() {
        studentSearchService.searchStudentById();
    }
}
