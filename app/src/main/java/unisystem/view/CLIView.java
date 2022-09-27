package unisystem.view;

import java.util.Scanner;

public class CLIView implements View {
    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public void printWelcomeMessage() {
        System.out.println("\n--------------------------------------------");
        System.out.println("----- UNIVERSITY ADMINISTRATION SYSTEM -----");
        System.out.println("--------------------------------------------\n");
    }

    @Override
    public void printMenuOptions() {
        System.out.println("\nSelect action:");

        System.out.println("1 - list students");
        System.out.println("\n0 - quit");
    }

    @Override
    public int selectOption() {
        int option = 0;

        System.out.print("\nSelect option: ");

        try {
            option = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("\nIncorrect input!");
        }

        return option;
    }
}
