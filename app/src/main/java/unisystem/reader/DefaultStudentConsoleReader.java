package unisystem.reader;

import unisystem.reader.validation.DefaultInputVerification;
import unisystem.reader.validation.InputVerification;

import java.util.Scanner;

public class DefaultStudentConsoleReader implements StudentConsoleReader{
    private static final Scanner scanner = new Scanner(System.in);
    private InputVerification inputVerification = new DefaultInputVerification();

    @Override
    public String readStudentName() {
        String name;

        do {
            System.out.print("Enter student name: ");
            name = scanner.nextLine();
        } while(!inputVerification.checkTextInput(name, 1, 12));

        return name;
    }

    @Override
    public String readStudentSurname() {
        String surname;

        do {
            System.out.print("Enter student surname: ");
            surname = scanner.nextLine();
        } while(!inputVerification.checkTextInput(surname, 1, 24));

        return surname;
    }

    @Override
    public String readStudentGender() {
        int genderOption = 0;

        do {
            System.out.print("Choose student gender: \n1 - MALE\n2 - FEMALE\n3 - OTHER\nEnter input: ");
            try {
                genderOption = scanner.nextInt();
            } catch (Exception e) {

            }
        } while(!inputVerification.checkNumberOptionInput(genderOption, 1, 3));

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
        return 0;
    }

    @Override
    public String readStudentEmail() {
        return null;
    }
}
