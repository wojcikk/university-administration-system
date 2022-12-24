package unisystem.view;

import org.springframework.stereotype.Component;

@Component
public class CLIAdminView implements AdminView {
    @Override
    public void printStudentMenuAdminOptions() {
        System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("\nSelect action:");

        System.out.println("1 - list students");
        System.out.println("2 - add student");
        System.out.println("3 - delete student");
        System.out.println("4 - edit student");
        System.out.println("5 - search student");
        System.out.println("\n0 - quit");
    }
    @Override
    public void printUniStructureMenuAdminOptions() {
        System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("\nSelect action:");

        System.out.println("1 - list majors");
        System.out.println("2 - list fields of study");
        System.out.println("3 - list degrees");
        System.out.println("4 - list faculties");
        System.out.println("\n0 - quit");
    }

    @Override
    public void printTeacherMenuAdminOptions() {
        System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("\nSelect action:");

        System.out.println("1 - list teachers");
        System.out.println("2 - add teacher");
        System.out.println("3 - delete teacher");
        System.out.println("4 - edit teacher");
        System.out.println("5 - search teacher");
        System.out.println("\n0 - quit");
    }
}
