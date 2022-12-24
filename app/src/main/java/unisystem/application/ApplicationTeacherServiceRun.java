package unisystem.application;

import org.springframework.stereotype.Component;
import unisystem.view.View;
import unisystem.service.TeacherService;

@Component
public class ApplicationTeacherServiceRun implements TeacherServiceRun{

    @Override
    public void runTeacherService(TeacherService teacherService, View view, boolean adminPermission) {
        System.out.println("::: TEACHERS STRUCTURE SERVICE :::");
        if(adminPermission) {
            runAdminTeacherService(teacherService, view);
        } else {
            runUserTeacherService(teacherService, view);
        }
    }

    private void runAdminTeacherService(TeacherService teacherService, View view) {
        int decision = 1;
        while (decision != 0) {

            view.getAdminView().printTeacherMenuAdminOptions();
            decision = view.selectOption(4);
            if (decision == 1) {
                System.out.println("\n::: LISTING TEACHERS FUNCTIONALITY :::");
                teacherService.listAllTeachers();
            } else if (decision == 2) {
                System.out.println("\n::: ADDING TEACHER FUNCTIONALITY :::");
                teacherService.addTeacher();
            } else if (decision == 3) {
                System.out.println("\n::: DELETING TEACHER FUNCTIONALITY :::");
                teacherService.deleteTeacher();
            } else if (decision == 4) {
                System.out.println("\n::: EDIT STUDENT FUNCTIONALITY :::");
                teacherService.editTeacher(view.selectTeacherEditingOption());
            } else if (decision == 5) {
                System.out.println("\n::: SEARCHING TEACHER FUNCTIONALITY :::");
                teacherService.searchTeacher(view.selectSearchingOption());
            }
        }
    }

    private void runUserTeacherService(TeacherService teacherService, View view) {
        int decision = 1;
        while (decision != 0) {
            view.getUserView().printTeacherMenuUserOptions();
            decision = view.selectOption(2);
            if (decision == 1) {
                System.out.println("\n::: LISTING TEACHERS FUNCTIONALITY :::");
                teacherService.listAllTeachers();
            } else if (decision == 2) {
                System.out.println("\n::: SEARCHING TEACHER FUNCTIONALITY :::");
                teacherService.searchTeacher(view.selectSearchingOption());
            }
        }
    }
}