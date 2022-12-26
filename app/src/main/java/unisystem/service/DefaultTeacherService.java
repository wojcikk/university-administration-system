package unisystem.service;

import org.springframework.stereotype.Service;
import unisystem.domain.Domain;
import unisystem.domain.Entitlements;
import unisystem.domain.Teacher;
import unisystem.domain.User;
import unisystem.reader.console.DefaultDomainConsoleReader;
import unisystem.reader.console.DomainConsoleReader;
import unisystem.repository.CentralRepository;
import unisystem.service.edit.DefaultTeacherEditService;
import unisystem.service.edit.DefaultUserEditService;
import unisystem.service.edit.TeacherEditService;
import unisystem.service.edit.UserEditService;
import unisystem.service.search.CLISearchView;
import unisystem.service.search.DefaultTeacherSearchService;
import unisystem.service.search.SearchView;
import unisystem.service.search.TeacherSearchService;

import java.util.Collections;
import java.util.List;

@Service
public class DefaultTeacherService implements TeacherService {
    private final CentralRepository centralRepository;
    private final DomainConsoleReader domainConsoleReader;
    private TeacherSearchService teacherSearchService;
    private TeacherEditService teacherEditService;
    private UserEditService userEditService;
    private SearchView searchView = new CLISearchView();
    private UserService userService;
    public DefaultTeacherService(CentralRepository centralRepository) {
        this.centralRepository = centralRepository;
        this.domainConsoleReader = new DefaultDomainConsoleReader(centralRepository);
        this.teacherSearchService = new DefaultTeacherSearchService(centralRepository);
        this.teacherEditService = new DefaultTeacherEditService(centralRepository);
        this.userEditService = new DefaultUserEditService(centralRepository);
        this.userService = new DefaultUserService(centralRepository);
    }

    @Override
    public List<Teacher> getTeachers() {
        return this.centralRepository.getTeacherRepository().findAll();
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
        Teacher newTeacher = domainConsoleReader.readTeacherEntryData();

        newTeacher.setId(this.centralRepository.getTeacherRepository().findAll().size());

        System.out.println("Added teacher: " + newTeacher.toString());

        this.userService.addUser(newTeacher.getEmail(), Entitlements.USER);

        this.centralRepository.getTeacherRepository().save(newTeacher);
    }

    @Override
    public void deleteTeacher() {
        long idToDelete = domainConsoleReader.readDomainIdToDelete(this.centralRepository.getTeacherRepository().findAll().size());

        System.out.println("Deleted teacher: " + this.centralRepository.getTeacherRepository().findAll().get((int) idToDelete).toString());

        this.userService.deleteUser(this.centralRepository.getTeacherRepository().findAll().get((int) idToDelete).getEmail());

        this.centralRepository.getTeacherRepository().deleteById(idToDelete);
    }

    @Override
    public void editTeacher(int option) {
        long idToEdit = domainConsoleReader.readDomainIdToEdit(this.centralRepository.getTeacherRepository().findAll().size());

        Teacher teacher = this.centralRepository.getTeacherRepository().findAll().get((int) idToEdit);

        User user = userService.findUserByEmail(teacher.getEmail());

        if(option == 1) { // all
            teacherEditService.editTeacher(teacher);
        } else if(option == 2) { // name
            teacherEditService.editTeacherName(teacher);
        } else if(option == 3) { // surname
            teacherEditService.editTeacherSurname(teacher);
        } else if(option == 4) { // gender
            teacherEditService.editTeacherGender(teacher);
        } else if(option == 5) { // age
            teacherEditService.editTeacherAge(teacher);
        } else if(option == 6) { // faculty
            teacherEditService.editTeacherFaculty(teacher);
        }
        userEditService.updateTeacherUserEmail(user, teacher);

        System.out.println("Edited teacher: " + teacher.toString());
        System.out.println("Edited user: " + user.toString());

        this.centralRepository.getUserRepository().save(user);
        this.centralRepository.getTeacherRepository().save(teacher);
    }

    @Override
    public void searchTeacher(int option) {
        List<Domain> searchedTeachers = null;
        if(option == 1) {
            searchedTeachers= Collections.singletonList(teacherSearchService.searchTeacherById());
        } else if(option == 2) {
            searchedTeachers = teacherSearchService.searchTeacherByName();
        } else if(option == 3) {
            searchedTeachers = teacherSearchService.searchTeacherBySurname();
        } else if(option == 4) {
            searchedTeachers = teacherSearchService.searchTeacherByGender();
        } else if(option == 5) {
            searchedTeachers = teacherSearchService.searchTeacherByAge();
        } else if(option == 6) {
            searchedTeachers = teacherSearchService.searchTeacherByEmail();

        }
        searchView.printSearchedList(searchedTeachers);

    }
}
