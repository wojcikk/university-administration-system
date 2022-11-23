package unisystem.service;

import unisystem.data.DataStore;
import unisystem.domain.Teacher;
import unisystem.reader.console.DefaultTeacherConsoleReader;
import unisystem.reader.console.TeacherConsoleReader;
import unisystem.service.search.CLISearchView;
import unisystem.service.search.DefaultTeacherSearchService;
import unisystem.service.search.SearchView;
import unisystem.service.search.TeacherSearchService;

import java.util.List;

public class DefaultTeacherService implements TeacherService {
    private final DataStore dataStore;
    private final TeacherConsoleReader teacherConsoleReader;
    private TeacherSearchService teacherSearchService;
    private SearchView searchView = new CLISearchView();
    public DefaultTeacherService(DataStore dataStore) {
        this.dataStore = dataStore;
        this.teacherConsoleReader = new DefaultTeacherConsoleReader(this.dataStore);
        this.teacherSearchService = new DefaultTeacherSearchService(this.dataStore);
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
        long idToDelete = teacherConsoleReader.readTeacherIdToDelete(dataStore.getTeachers());

        System.out.println("Deleted teacher: " + this.dataStore.getTeachers().get((int) idToDelete).toString());

        this.dataStore.getTeachers().remove((int) idToDelete);
    }

    @Override
    public void searchTeacher(int option) {
        if(option == 1) {
            Teacher searchedTeacher = teacherSearchService.searchTeacherById();

            searchView.printSearchedTeacherElement(searchedTeacher);
        } else if(option == 2) {
            List<Teacher> searchedTeachers = teacherSearchService.searchTeacherByName();

            searchView.printSearchedTeacherList(searchedTeachers);
        } else if(option == 3) {
            List<Teacher> searchedTeachers = teacherSearchService.searchTeacherBySurname();

            searchView.printSearchedTeacherList(searchedTeachers);
        } else if(option == 4) {
            List<Teacher> searchedTeachers = teacherSearchService.searchTeacherByGender();

            searchView.printSearchedTeacherList(searchedTeachers);
        } else if(option == 5) {
            List<Teacher> searchedTeachers = teacherSearchService.searchTeacherByAge();

            searchView.printSearchedTeacherList(searchedTeachers);
        } else if(option == 6) {
            List<Teacher> searchedTeachers = teacherSearchService.searchTeacherByEmail();

            searchView.printSearchedTeacherList(searchedTeachers);
        }
    }
}
