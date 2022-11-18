package unisystem.service;

import unisystem.data.DataStore;
import unisystem.domain.Teacher;
import unisystem.reader.console.DefaultTeacherConsoleReader;
import unisystem.reader.console.TeacherConsoleReader;

public class DefaultTeacherService implements TeacherService {
    private final DataStore dataStore;
    private final TeacherConsoleReader teacherConsoleReader;

    public DefaultTeacherService(DataStore dataStore) {
        this.dataStore = dataStore;
        this.teacherConsoleReader = new DefaultTeacherConsoleReader(this.dataStore);
    }

    @Override
    public void listAllTeachers() {
        System.out.printf("%-5s %-20s %-20s %-10s %-10s %-30s %-40s\n",
                "ID", "NAME", "SURNAME", "GENDER", "AGE", "EMAIL", "FACULTY"
        );

        dataStore.getTeachers().forEach(teacher -> {
            System.out.printf("%-5s %-20s %-20s %-10s %-10s %-30s %-40s\n",
                    teacher.getId(),
                    teacher.getPerson().getName(),
                    teacher.getPerson().getSurname(),
                    teacher.getPerson().getGender(),
                    teacher.getPerson().getAge(),
                    teacher.getEmail(),
                    teacher.getFaculty().getName());
        });
    }

    @Override
    public void addTeacher() {
        Teacher newTeacher = teacherConsoleReader.readTeacherEntryData();

        newTeacher.setId(dataStore.getTeachers().size());

        System.out.println("Added teacher: " + newTeacher.toString());

        this.dataStore.getTeachers().add(newTeacher);
    }

    @Override
    public void deleteTeacher() {

    }

    @Override
    public void searchSearch(int option) {

    }
}
