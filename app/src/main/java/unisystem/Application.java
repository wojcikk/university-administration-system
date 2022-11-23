package unisystem;

import unisystem.application.ApplicationServiceRun;
import unisystem.application.ServiceRun;
import unisystem.data.DataStore;
import unisystem.data.FileDataStore;
import unisystem.reader.file.view.CLIView;
import unisystem.reader.file.view.View;
import unisystem.service.*;

public class Application {
    public static void main(String[] args) {
        run();
    }

    private static void run() {
        DataStore dataStore = new FileDataStore();
        dataStore.init();

        StudentService studentService = new DefaultStudentService(dataStore);
        MajorService majorService = new DefaultMajorService(dataStore);
        TeacherService teacherService = new DefaultTeacherService(dataStore);

        View view = new CLIView();

        view.printWelcomeMessage();

        int decision = 1;
        while(decision != 0) {
            view.printStartingApplicationModeOptions();
            decision = view.selectOption(2);
            if (decision == 1) {    // user
                runServiceOptions(studentService, majorService, teacherService, view, false);
            } else if (decision == 2) {   // admin
                runServiceOptions(studentService, majorService, teacherService, view, true);
            }
        }

    }

    private static void runServiceOptions(StudentService studentService, MajorService majorService, TeacherService teacherService, View view, boolean adminPermission) {
        ServiceRun applicationServiceRun = new ApplicationServiceRun();

        int decision = 1;
        while(decision != 0) {
            view.printEntryMenuOptions();
            decision = view.selectOption(3);

            if (decision == 1) {
                applicationServiceRun.getStudentServiceRun().runStudentService(studentService, view, adminPermission);
            } else if (decision == 2) {
                applicationServiceRun.getUniStructureServiceRun().runUniStructureService(majorService, view, adminPermission);
            } else if (decision == 3) {
                applicationServiceRun.getTeacherServiceRun().runTeacherService(teacherService, view, adminPermission);
            }
        }
    }
}