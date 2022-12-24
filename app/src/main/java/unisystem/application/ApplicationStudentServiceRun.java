package unisystem.application;

import org.springframework.stereotype.Component;
import unisystem.view.View;
import unisystem.service.StudentService;

@Component
public class ApplicationStudentServiceRun implements StudentServiceRun{

    @Override
    public void runStudentService(StudentService studentService, View view, boolean adminPermission) {
        System.out.println("::: STUDENT SERVICE :::");
        if(adminPermission) {
            runAdminStudentService(studentService, view);
        } else {
            runUserStudentService(studentService, view);
        }
    }

    private void runAdminStudentService(StudentService studentService, View view) {
        int decision = 1;
        while (decision != 0) {
            view.getAdminView().printStudentMenuAdminOptions();
            decision = view.selectOption(4);

            if (decision == 1) {
                System.out.println("\n::: LISTING STUDENT FUNCTIONALITY :::");
                studentService.listAllStudents();
            } else if (decision == 2) {
                System.out.println("\n::: ADDING STUDENT FUNCTIONALITY :::");
                studentService.addStudent();
            } else if (decision == 3) {
                System.out.println("\n::: DELETING STUDENT FUNCTIONALITY :::");
                studentService.deleteStudent();
            } else if (decision == 4) {
                System.out.println("\n::: EDIT STUDENT FUNCTIONALITY :::");
                studentService.editStudent(view.selectStudentEditingOption());
            } else if (decision == 5) {
                System.out.println("\n::: SEARCHING STUDENT FUNCTIONALITY :::");
                studentService.searchStudent(view.selectSearchingOption());
            }
        }
    }

    private void runUserStudentService(StudentService studentService, View view) {
        int decision = 1;
        while (decision != 0) {
            view.getUserView().printStudentMenuUserOptions();
            decision = view.selectOption(2);

            if (decision == 1) {
                System.out.println("\n::: LISTING STUDENT FUNCTIONALITY :::");
                studentService.listAllStudents();
            } else if (decision == 2) {
                System.out.println("\n::: SEARCHING STUDENT FUNCTIONALITY :::");
                studentService.searchStudent(view.selectSearchingOption());
            }
        }
    }
}