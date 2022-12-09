package unisystem.application;

import org.springframework.stereotype.Component;
import unisystem.view.View;
import unisystem.service.MajorService;

@Component
public class ApplicationUniStructureServiceRun implements UniStructureServiceRun {

    @Override
    public void runUniStructureService(MajorService majorService, View view, boolean adminPermission) {
        System.out.println("::: UNI STRUCTURE SERVICE :::");
        if(adminPermission) {
            runAdminUniStructureService(majorService, view);
        } else {
            runUserUniStructureService(majorService, view);
        }
    }

    private void runAdminUniStructureService(MajorService majorService, View view) {
        int decision = 1;
        while (decision != 0) {
            view.getAdminView().printUniStructureMenuAdminOptions();
            decision = view.selectOption(4);
            if (decision == 1) {
                System.out.println("\n::: LISTING MAJORS FUNCTIONALITY :::");
                majorService.listAllMajors();
            } else if (decision == 2) {
                System.out.println("\n::: LISTING FIELDS OF STUDY FUNCTIONALITY :::");
                majorService.listAllFieldsOfStudy();
            } else if (decision == 3) {
                System.out.println("\n::: LISTING DEGREES FUNCTIONALITY :::");
                majorService.listAllDegrees();
            } else if (decision == 4) {
                System.out.println("\n::: LISTING FACULTIES FUNCTIONALITY :::");
                majorService.listAllFaculties();
            }
        }
    }

    private void runUserUniStructureService(MajorService majorService, View view) {
        int decision = 1;
        while (decision != 0) {
            view.getUserView().printUniStructureMenuUserOptions();
            decision = view.selectOption(4);
            if (decision == 1) {
                System.out.println("\n::: LISTING MAJORS FUNCTIONALITY :::");
                majorService.listAllMajors();
            } else if (decision == 2) {
                System.out.println("\n::: LISTING FIELDS OF STUDY FUNCTIONALITY :::");
                majorService.listAllFieldsOfStudy();
            } else if (decision == 3) {
                System.out.println("\n::: LISTING DEGREES FUNCTIONALITY :::");
                majorService.listAllDegrees();
            } else if (decision == 4) {
                System.out.println("\n::: LISTING FACULTIES FUNCTIONALITY :::");
                majorService.listAllFaculties();
            }
        }
    }
}