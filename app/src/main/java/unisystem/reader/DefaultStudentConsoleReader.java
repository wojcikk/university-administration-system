package unisystem.reader;

import unisystem.domain.Student;
import unisystem.reader.validation.DefaultInputVerification;
import unisystem.reader.validation.InputVerification;

import java.util.List;
import java.util.Scanner;

public class DefaultStudentConsoleReader implements StudentConsoleReader {
    private static final Scanner scanner = new Scanner(System.in);
    private InputVerification inputVerification = new DefaultInputVerification();
    private ConsoleReader consoleReader = new DefaultConsoleReader();

    @Override
    public Student readStudentEntryData() {
        String name = readStudentName();

        String surname = readStudentSurname();

        String gender = readStudentGender();

        long age = readStudentAge();

        String email = readStudentEmail();

        return new Student(name, surname, gender, age, email);
    }

    @Override
    public long readStudentId() {
        long id = 0;

        do {
            System.out.print("\nEnter student id: ");
            id = consoleReader.readInteger();
        } while (!inputVerification.checkNumberInput((int) id, 0, Integer.MAX_VALUE));

        return id;
    }

    @Override
    public long readStudentIdToDelete(List<Student> students) {
        long id = 0;

        do {
            System.out.print("\nEnter student id to delete: ");
            id = consoleReader.readInteger();
        } while (!inputVerification.checkNumberInput((int) id, 0, students.size()));

        return id;
    }

    @Override
    public String readStudentName() {
        String name;

        do {
            System.out.print("\nEnter student name: ");
            name = scanner.nextLine();
        } while(!(inputVerification.checkTextInput(name) && inputVerification.checkInputLength(name, 1, 24)));

        return name;
    }
    @Override
    public String readStudentSurname() {
        String surname;

        do {
            System.out.print("\nEnter student surname: ");
            surname = scanner.nextLine();
        } while(!(inputVerification.checkTextInput(surname) && inputVerification.checkInputLength(surname, 1, 24)));

        return surname;
    }

    @Override
    public String readStudentGender() {
        int genderOption = 0;

        do {
            System.out.print("\nChoose student gender: \n1 - MALE\n2 - FEMALE\n3 - OTHER\nChoose option: ");
            genderOption = consoleReader.readInteger();
        } while(!inputVerification.checkNumberInput(genderOption, 1, 3));

        if(genderOption == 1) {
            return "MALE";
        } else if(genderOption == 2) {
            return "FEMALE";
        } else {
            return "OTHER";
        }
    }

    @Override
    public long readStudentAge() {
        long age = 0;

        do {
            System.out.print("\nEnter student age: ");
            age = consoleReader.readInteger();
        } while (!inputVerification.checkNumberInput((int) age, 1, Integer.MAX_VALUE));

        return age;
    }

    @Override
    public String readStudentEmail() {
        String email;

        do {
            System.out.print("Enter student email: ");
            email = scanner.nextLine();
        } while(!(inputVerification.checkEmailInput(email) && inputVerification.checkInputLength(email, 1, 24)));

        return email;
    }
}
