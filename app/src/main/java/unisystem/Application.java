package unisystem;

import unisystem.data.DataStore;
import unisystem.data.FileDataStore;
import unisystem.view.CLIView;
import unisystem.view.View;

public class Application {
    public static void main(String[] args) {
        run();
    }

    private static void run() {
        DataStore dataStore = new FileDataStore();
        View view = new CLIView();

        dataStore.init();

        view.printWelcomeMessage();

        int decision = 1;

        while(decision != 0) {
            view.printMenuOptions();
            decision = view.selectOption();

            if(decision == 1) {
                dataStore.getStudents().forEach(student -> {
                    System.out.println(student.toString());
                });
            }
        }



    }
}