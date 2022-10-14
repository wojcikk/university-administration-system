package unisystem;

import unisystem.data.DataStore;
import unisystem.data.FileDataStore;
import unisystem.service.DefaultStudentService;
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

        View view = new CLIView();


        view.printWelcomeMessage();

        int decision = 1;

        while(decision != 0) {
            view.printMenuOptions();
            decision = view.selectOption();

            if(decision == 1) {
                dataStore.getStudents().forEach(student -> {
                    System.out.println(student.toString());
                });
            } else if(decision == 2) {
                System.out.println("\n::: ADDING STUDENT FUNCTIONALITY :::");
                studentService.addStudent();
            } else if(decision == 3) {
                System.out.println("\n::: DELETING STUDENT FUNCTIONALITY :::");
                studentService.deleteStudent();
            } else if(decision == 4) {
                System.out.println("\n::: SEARCHING STUDENT FUNCTIONALITY :::");

                studentService.searchStudent(view.selectSearchingOption());
            }
        }



    }
}