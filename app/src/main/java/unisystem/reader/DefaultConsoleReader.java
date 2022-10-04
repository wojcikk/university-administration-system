package unisystem.reader;

import unisystem.domain.Student;

import java.util.Scanner;

public class DefaultConsoleReader implements ConsoleReader {
    private static final Scanner scanner = new Scanner(System.in);
    private StudentConsoleReader studentConsoleReader = new DefaultStudentConsoleReader();

    public Student readStudentEntryData() {
//        System.out.println("Enter student name: (between 1 and 12 characters, no numbers or special characters)");
//        String name = scanner.nextLine();

        String name = studentConsoleReader.readStudentName();

        String surname = studentConsoleReader.readStudentSurname();

        String gender = studentConsoleReader.readStudentGender();

        System.out.println("Enter student age: ");
        long age = scanner.nextLong();
        scanner.nextLine();

        System.out.println("Enter student email: ");
        String email = scanner.nextLine();

        return new Student(name, surname, gender, age, email);
    }
}
