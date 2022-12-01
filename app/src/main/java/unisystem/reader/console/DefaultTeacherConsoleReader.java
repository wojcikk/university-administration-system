package unisystem.reader.console;

import org.springframework.stereotype.Component;
import unisystem.data.DataStore;
import unisystem.domain.*;
import unisystem.reader.validation.DefaultInputVerification;
import unisystem.reader.validation.InputVerification;

import java.util.List;
import java.util.Scanner;

@Component
public class DefaultTeacherConsoleReader implements TeacherConsoleReader {
    private static final Scanner scanner = new Scanner(System.in);
    private InputVerification inputVerification = new DefaultInputVerification();
    private ConsoleReader consoleReader = new DefaultConsoleReader();
    private final DataStore dataStore;

    public DefaultTeacherConsoleReader(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public Teacher readTeacherEntryData() {
        String name = readTeacherName();

        String surname = readTeacherSurname();

        String gender = readTeacherGender();

        long age = readTeacherAge();

        String email = readTeacherEmail();

        Faculty faculty = readTeacherFaculty();

        return new Teacher(name, surname, gender, age, email, faculty);
    }

    @Override
    public long readTeacherId() {
        long id = 0;

        do {
            System.out.print("\nEnter teacher id: ");
            id = consoleReader.readInteger();
        } while (!inputVerification.checkNumberInput((int) id, 0, Integer.MAX_VALUE));

        return id;
    }

    @Override
    public long readTeacherIdToDelete(List<Teacher> teachers) {
        long id = 0;

        do {
            System.out.print("\nEnter teacher id to delete: ");
            id = consoleReader.readInteger();
        } while (!inputVerification.checkNumberInput((int) id, 0, teachers.size()));

        return id;
    }

    @Override
    public String readTeacherName() {
        String name;

        do {
            System.out.print("\nEnter teacher name: ");
            name = scanner.nextLine();
        } while(!(inputVerification.checkTextInput(name) && inputVerification.checkInputLength(name, 1, 24)));

        return name;
    }
    @Override
    public String readTeacherSurname() {
        String surname;

        do {
            System.out.print("\nEnter teacher surname: ");
            surname = scanner.nextLine();
        } while(!(inputVerification.checkTextInput(surname) && inputVerification.checkInputLength(surname, 1, 24)));

        return surname;
    }

    @Override
    public String readTeacherGender() {
        int genderOption = 0;

        do {
            System.out.print("\nChoose teacher gender: ");
            printGenderOptions();
            System.out.println("\nChoose option: ");
            genderOption = consoleReader.readInteger();
        } while(!inputVerification.checkNumberInput(genderOption, 1, 3));

        if(genderOption == 1) {
            return "Male";
        } else if(genderOption == 2) {
            return "Female";
        } else {
            return "Other";
        }
    }

    @Override
    public long readTeacherAge() {
        long age = 0;

        do {
            System.out.print("\nEnter teacher age: ");
            age = consoleReader.readInteger();
        } while (!inputVerification.checkNumberInput((int) age, 1, Integer.MAX_VALUE));

        return age;
    }

    @Override
    public String readTeacherEmail() {
        String email;

        do {
            System.out.print("\nEnter teacher email: ");
            email = scanner.nextLine();
        } while(!(inputVerification.checkEmailInput(email) && inputVerification.checkInputLength(email, 1, 24)));

        return email;
    }

    @Override
    public Faculty readTeacherFaculty() {
        System.out.println("\nChoose faculty option: ");
        printFacultyOptions();
        long facultyId = 0;

        do {
            System.out.print("\nChoose option: ");
            facultyId = consoleReader.readInteger();
        } while (!inputVerification.checkNumberInput((int) facultyId, 1, dataStore.getFaculties().size()));


        return dataStore.getFaculties().get((int) (facultyId - 1));
    }

    private void printFacultyOptions() {
        int i = 1;
        for(Faculty faculty : dataStore.getFaculties()) {
            System.out.println(i++ + " - " + faculty.getName());
        }
    }

    private void printGenderOptions() {
        System.out.print("\n1 - MALE\n2 - FEMALE\n3 - OTHER");
    }
}
