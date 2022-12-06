package unisystem.service;

import org.springframework.stereotype.Service;
import unisystem.domain.Teacher;
import unisystem.reader.console.DefaultTeacherConsoleReader;
import unisystem.reader.console.TeacherConsoleReader;
import unisystem.repository.CentralRepository;
import unisystem.service.search.CLISearchView;
import unisystem.service.search.DefaultTeacherSearchService;
import unisystem.service.search.SearchView;
import unisystem.service.search.TeacherSearchService;

import java.util.List;

@Service
public class DefaultTeacherService implements TeacherService {
    private final CentralRepository centralRepository;
    private final TeacherConsoleReader teacherConsoleReader;
    private TeacherSearchService teacherSearchService;
    private SearchView searchView = new CLISearchView();
    public DefaultTeacherService(CentralRepository centralRepository) {
        this.centralRepository = centralRepository;
        this.teacherConsoleReader = new DefaultTeacherConsoleReader(centralRepository);
        this.teacherSearchService = new DefaultTeacherSearchService(centralRepository);
    }

    @Override
    public void listAllTeachers() {
        System.out.printf("%-5s %-20s %-20s %-10s %-10s %-30s %-40s\n",
                "ID", "NAME", "SURNAME", "GENDER", "AGE", "EMAIL", "FACULTY"
        );

        this.centralRepository.getTeacherRepository().findAll().forEach(teacher -> {
            System.out.printf("%-5s %-20s %-20s %-10s %-10s %-30s %-40s\n",
                    teacher.getId(),
                    teacher.getName(),
                    teacher.getSurname(),
                    teacher.getGender(),
                    teacher.getAge(),
                    teacher.getEmail(),
                    teacher.getFaculty().getName());
        });
    }

    @Override
    public void addTeacher() {
        Teacher newTeacher = teacherConsoleReader.readTeacherEntryData();

        newTeacher.setId(this.centralRepository.getTeacherRepository().findAll().size());

        System.out.println("Added teacher: " + newTeacher.toString());

        this.centralRepository.getTeacherRepository().save(newTeacher);
    }

    @Override
    public void deleteTeacher() {
        long idToDelete = teacherConsoleReader.readTeacherIdToDelete(this.centralRepository.getTeacherRepository().findAll());

        System.out.println("Deleted teacher: " + this.centralRepository.getTeacherRepository().findAll().get((int) idToDelete).toString());

        //this.centralRepository.getTeacherRepository().delete(this.centralRepository.getTeacherRepository().getById(idToDelete));
        this.centralRepository.getTeacherRepository().deleteById(idToDelete);
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
