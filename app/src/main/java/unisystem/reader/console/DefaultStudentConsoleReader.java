package unisystem.reader.console;

import org.springframework.stereotype.Component;
import unisystem.data.DataStore;
import unisystem.domain.Major;
import unisystem.domain.Student;
import unisystem.reader.validation.DefaultInputVerification;
import unisystem.reader.validation.InputVerification;
import unisystem.repository.MajorRepository;
import unisystem.repository.StudentRepository;

import java.util.List;
import java.util.Scanner;

@Component
public class DefaultStudentConsoleReader implements StudentConsoleReader {
    private static final Scanner scanner = new Scanner(System.in);
    private InputVerification inputVerification = new DefaultInputVerification();
    private ConsoleReader consoleReader = new DefaultConsoleReader();
    private final DataStore dataStore;
    private final StudentRepository studentRepository;
    private final MajorRepository majorRepository;

    public DefaultStudentConsoleReader(StudentRepository studentRepository, MajorRepository majorRepository, DataStore dataStore) {
        this.studentRepository = studentRepository;
        this.majorRepository = majorRepository;
        this.dataStore = dataStore;
    }

    @Override
    public Student readStudentEntryData() {
        String name = readStudentName();

        String surname = readStudentSurname();

        String gender = readStudentGender();

        long age = readStudentAge();

        String email = readStudentEmail();

        Major major = readStudentMajor();

        return new Student(name, surname, gender, age, email, major);
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
            System.out.print("\nChoose student gender: ");
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
            System.out.print("\nEnter student email: ");
            email = scanner.nextLine();
        } while(!(inputVerification.checkEmailInput(email) && inputVerification.checkInputLength(email, 1, 24)));

        return email;
    }

    @Override
    public Major readStudentMajor() {
        System.out.println("\nChoose major option: ");
        printMajorsOptions();
        long majorId = 0;

        do {
            System.out.print("\nChoose option: ");
            majorId = consoleReader.readInteger();
        } while (!inputVerification.checkNumberInput((int) majorId, 1, majorRepository.findAll().size()));


        return dataStore.getMajors().get((int) (majorId - 1));
    }

    private void printMajorsOptions() {
        int i = 1;
        for(Major major : majorRepository.findAll()) {
            System.out.println(i++ + " - " + major.getFieldOfStudy().getName() + ", " + major.getDegree().getName() + ", " + major.getFaculty().getName());
        }
    }

    private void printGenderOptions() {
        System.out.print("\n1 - MALE\n2 - FEMALE\n3 - OTHER");
    }
}
