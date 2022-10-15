package unisystem;

import unisystem.data.DataStore;
import unisystem.data.FileDataStore;
import unisystem.service.DefaultMajorService;
import unisystem.service.DefaultStudentService;
import unisystem.service.MajorService;
import unisystem.service.StudentService;
import unisystem.view.CLIView;
import unisystem.view.View;

public class Application {
    public static void main(String[] args) {
        run();
    }

    private static void run() {
        DataStore dataStore = new FileDataStore();
        dataStore.init();

        StudentService studentService = new DefaultStudentService(dataStore);
        MajorService majorService = new DefaultMajorService(dataStore);

        View view = new CLIView();

        view.printWelcomeMessage();

        int decision = 1;
        while(decision != 0) {
            view.printEntryMenuOptions();
            decision = view.selectOption();

            if (decision == 1) {
                runStudentService(studentService, view);
            } else if (decision == 2) {
                runUniStructureService(majorService, view);
            }
        }
    }

    private static void runStudentService(StudentService studentService, View view) {
        System.out.println("\n::: STUDENT SERVICE :::");
        int decision = 1;
        while (decision != 0) {
            view.printStudentMenuOptions();
            decision = view.selectOption();

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
                System.out.println("\n::: SEARCHING STUDENT FUNCTIONALITY :::");
                studentService.searchStudent(view.selectSearchingOption());
            }
        }
    }
    private static void runUniStructureService(MajorService majorService, View view) {
        System.out.println("\n::: UNI STRUCTURE SERVICE :::");
        int decision = 1;
        while (decision != 0) {
            view.printUniStructureMenuOptions();
            decision = view.selectOption();
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