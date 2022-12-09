package unisystem.reader.console;

import org.springframework.stereotype.Component;
import unisystem.domain.*;
import unisystem.reader.validation.DefaultInputVerification;
import unisystem.reader.validation.InputVerification;
import unisystem.repository.CentralRepository;

import java.util.Scanner;

@Component
public class DefaultDomainConsoleReader implements DomainConsoleReader {
    private static final Scanner scanner = new Scanner(System.in);
    private InputVerification inputVerification = new DefaultInputVerification();
    private ConsoleReader consoleReader = new DefaultConsoleReader();
    private final CentralRepository centralRepository;

    public DefaultDomainConsoleReader(CentralRepository centralRepository) {
        this.centralRepository = centralRepository;
    }

    @Override
    public Student readStudentEntryData() {
            String name = readDomainName();

            String surname = readDomainSurname();

            String gender = readDomainGender();

            long age = readDomainAge();

            String email = readDomainEmail();

            Major major = readDomainMajor();

            return new Student(name, surname, gender, age, email, major);
    }

    @Override
    public Teacher readTeacherEntryData() {
        String name = readDomainName();

        String surname = readDomainSurname();

        String gender = readDomainGender();

        long age = readDomainAge();

        String email = readDomainEmail();

        Faculty faculty = readFaculty();

        return new Teacher(name, surname, gender, age, email, faculty);
    }

    @Override
    public long readDomainId() {
        long id = 0;

        do {
            System.out.print("\nEnter id: ");
            id = consoleReader.readInteger();
        } while (!inputVerification.checkNumberInput((int) id, 0, Integer.MAX_VALUE));

        return id;
    }

    @Override
    public long readDomainIdToDelete(int max) {
        long id = 0;

        do {
            System.out.print("\nEnter id to delete: ");
            id = consoleReader.readInteger();
        } while (!inputVerification.checkNumberInput((int) id, 0, max));

        return id;
    }

    @Override
    public String readDomainName() {
        String name;

        do {
            System.out.print("\nEnter name: ");
            name = scanner.nextLine();
        } while(!(inputVerification.checkTextInput(name) && inputVerification.checkInputLength(name, 1, 24)));

        return name;
    }
    @Override
    public String readDomainSurname() {
        String surname;

        do {
            System.out.print("\nEnter surname: ");
            surname = scanner.nextLine();
        } while(!(inputVerification.checkTextInput(surname) && inputVerification.checkInputLength(surname, 1, 24)));

        return surname;
    }

    @Override
    public String readDomainGender() {
        int genderOption = 0;

        do {
            System.out.print("\nChoose gender: ");
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
    public long readDomainAge() {
        long age = 0;

        do {
            System.out.print("\nEnter age: ");
            age = consoleReader.readInteger();
        } while (!inputVerification.checkNumberInput((int) age, 1, Integer.MAX_VALUE));

        return age;
    }

    @Override
    public String readDomainEmail() {
        String email;

        do {
            System.out.print("\nEnter email: ");
            email = scanner.nextLine();
        } while(!(inputVerification.checkEmailInput(email) && inputVerification.checkInputLength(email, 1, 24)));

        return email;
    }

    @Override
    public Major readDomainMajor() {
        System.out.println("\nChoose major option: ");
        printMajorsOptions();
        long majorId = 0;

        do {
            System.out.print("\nChoose option: ");
            majorId = consoleReader.readInteger();
        } while (!inputVerification.checkNumberInput((int) majorId, 1, this.centralRepository.getMajorRepository().findAll().size()));


        return centralRepository.getMajorRepository().findAll().get((int) (majorId - 1));
    }

    @Override
    public Faculty readFaculty() {
        System.out.println("\nChoose faculty option: ");
        printFacultyOptions();
        long facultyId = 0;

        do {
            System.out.print("\nChoose option: ");
            facultyId = consoleReader.readInteger();
        } while (!inputVerification.checkNumberInput((int) facultyId, 1, this.centralRepository.getFacultyRepository().findAll().size()));


        return this.centralRepository.getFacultyRepository().findAll().get((int) (facultyId - 1));
    }

    private void printMajorsOptions() {
        int i = 1;
        for(Major major : this.centralRepository.getMajorRepository().findAll()) {
            System.out.println(i++ + " - " + major.getFieldOfStudy().getName() + ", " + major.getDegree().getName() + ", " + major.getFaculty().getName());
        }
    }

    private void printFacultyOptions() {
        int i = 1;
        for(Faculty faculty : this.centralRepository.getFacultyRepository().findAll()) {
            System.out.println(i++ + " - " + faculty.getName());
        }
    }

    private void printGenderOptions() {
        System.out.print("\n1 - MALE\n2 - FEMALE\n3 - OTHER");
    }
}
