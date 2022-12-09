package unisystem.view;

import org.springframework.stereotype.Component;

@Component
public class CLIUserView implements UserView {
    @Override
    public void printStudentMenuUserOptions() {
        System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("\nSelect action:");

        System.out.println("1 - list students");
        System.out.println("2 - search student");
        System.out.println("\n0 - quit");
    }
    @Override
    public void printUniStructureMenuUserOptions() {
        System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("\nSelect action:");

        System.out.println("1 - list majors");
        System.out.println("2 - list fields of study");
        System.out.println("3 - list degrees");
        System.out.println("4 - list faculties");
        System.out.println("\n0 - quit");
    }

    @Override
    public void printTeacherMenuUserOptions() {
        System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("\nSelect action:");

        System.out.println("1 - list teachers");
        System.out.println("2 - search teacher");
        System.out.println("\n0 - quit");
    }
}
