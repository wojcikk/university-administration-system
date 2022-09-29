package unisystem.service;

import unisystem.data.DataStore;
import unisystem.domain.Student;
import unisystem.reader.ConsoleReader;
import unisystem.reader.DefaultConsoleReader;

public class DefaultStudentService implements StudentService {
    private final DataStore dataStore;
    private static final ConsoleReader consoleReader = new DefaultConsoleReader();

    public DefaultStudentService(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public void addStudent() {
        Student newStudent = consoleReader.readStudentEntryData();

        newStudent.setId(dataStore.getStudents().size());

        this.dataStore.getStudents().add(newStudent);
    }

    @Override
    public void deleteStudent() {

    }

    @Override
    public void searchStudent() {

    }
}
