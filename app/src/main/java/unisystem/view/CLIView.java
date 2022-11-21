package unisystem.view;

import unisystem.reader.console.ConsoleReader;
import unisystem.reader.console.DefaultConsoleReader;
import unisystem.reader.validation.DefaultInputVerification;
import unisystem.reader.validation.InputVerification;

public class CLIView implements View {
    private InputVerification inputVerification = new DefaultInputVerification();
    private ConsoleReader consoleReader = new DefaultConsoleReader();

    @Override
    public void printWelcomeMessage() {
        System.out.println("\n--------------------------------------------");
        System.out.println("----- UNIVERSITY ADMINISTRATION SYSTEM -----");
        System.out.println("--------------------------------------------\n");
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
    public void printStudentMenuOptions() {
        System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("\nSelect action:");

        System.out.println("1 - list students");
        System.out.println("2 - add student");
        System.out.println("3 - delete student");
        System.out.println("4 - search student");
        System.out.println("\n0 - quit");
    }
    @Override
    public void printUniStructureMenuOptions() {
        System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("\nSelect action:");

        System.out.println("1 - list majors");
        System.out.println("2 - list fields of study");
        System.out.println("3 - list degrees");
        System.out.println("4 - list faculties");
        System.out.println("\n0 - quit");
    }

    @Override
    public void printTeacherMenuOptions() {
        System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("\nSelect action:");

        System.out.println("1 - list teachers");
        System.out.println("2 - add teacher");
        System.out.println("3 - delete teacher");
        System.out.println("\n0 - quit");
    }

    @Override
    public void printSearchingOptions() {
        System.out.println("\nSelect searching:");

        System.out.println("1 - search by id");
        System.out.println("2 - search by name");
        System.out.println("3 - search by surname");
        System.out.println("4 - search by gender");
        System.out.println("0 - quit");
    }

    @Override
    public int selectOption() {
        int option = 0;

        do {
            System.out.print("\nSelect option: ");
            option = consoleReader.readInteger();
        } while(!inputVerification.checkNumberInput(option, 0, 5));

        System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - -\n");

        return option;
    }

    public int selectSearchingOption() {
        printSearchingOptions();

        return selectOption();
    }
}
