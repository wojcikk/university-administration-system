package unisystem.view;

import org.springframework.stereotype.Component;
import unisystem.reader.console.ConsoleReader;
import unisystem.reader.console.DefaultConsoleReader;
import unisystem.reader.validation.DefaultInputVerification;
import unisystem.reader.validation.InputVerification;

@Component
public class CLIView implements View {
    private InputVerification inputVerification = new DefaultInputVerification();
    private ConsoleReader consoleReader = new DefaultConsoleReader();

    private AdminView adminView = new CLIAdminView();
    private UserView userView = new CLIUserView();

    @Override
    public void printWelcomeMessage() {
        System.out.println("\n--------------------------------------------");
        System.out.println("----- UNIVERSITY ADMINISTRATION SYSTEM -----");
        System.out.println("--------------------------------------------\n");
    }

    @Override
    public void printStartingApplicationModeOptions() {
        System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("\nSelect mode:");

        System.out.println("1 - user mode");
        System.out.println("2 - admin mode");

        System.out.println("\n0 - quit");
    }


    @Override
    public void printEntryMenuOptions() {
        System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("\nSelect action:");

        System.out.println("1 - student service");
        System.out.println("2 - uni structure service");
        System.out.println("3 - teacher service");

        System.out.println("\n0 - quit");
    }

    @Override
    public void printSearchingOptions() {
        System.out.println("\nSelect searching:");

        System.out.println("1 - search by id");
        System.out.println("2 - search by name");
        System.out.println("3 - search by surname");
        System.out.println("4 - search by gender");
        System.out.println("5 - search by age");
        System.out.println("6 - search by email");
        System.out.println("0 - quit");
    }

    @Override
    public void printStudentEditOptions() {
        System.out.println("\nSelect student parameters to edit:");

        System.out.println("1 - edit all parameters");
        System.out.println("2 - edit name");
        System.out.println("3 - edit surname");
        System.out.println("4 - edit gender");
        System.out.println("5 - edit age");
        System.out.println("6 - edit major");
        System.out.println("0 - quit");
    }

    @Override
    public void printTeacherEditOptions() {
        System.out.println("\nSelect student parameters to edit:");

        System.out.println("1 - edit all parameters");
        System.out.println("2 - edit name");
        System.out.println("3 - edit surname");
        System.out.println("4 - edit gender");
        System.out.println("5 - edit age");
        System.out.println("6 - edit faculty");
        System.out.println("0 - quit");
    }

    @Override
    public int selectOption(int maxRange) {
        int option = 0;

        do {
            System.out.print("\nSelect option: ");
            option = consoleReader.readInteger();
        } while(!inputVerification.checkNumberInput(option, 0, maxRange));

        System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - -\n");

        return option;
    }

    @Override
    public int selectSearchingOption() {
        printSearchingOptions();

        return selectOption(6);
    }

    @Override
    public int selectStudentEditingOption() {
        printStudentEditOptions();

        return selectOption(6);
    }
    @Override
    public int selectTeacherEditingOption() {
        printTeacherEditOptions();

        return selectOption(6);
    }

    @Override
    public AdminView getAdminView() {
        return adminView;
    }

    @Override
    public UserView getUserView() {
        return userView;
    }
}
