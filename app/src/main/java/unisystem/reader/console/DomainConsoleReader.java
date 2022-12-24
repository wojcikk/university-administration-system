package unisystem.reader.console;

import unisystem.domain.Faculty;
import unisystem.domain.Major;
import unisystem.domain.Student;
import unisystem.domain.Teacher;

public interface DomainConsoleReader {
    Student readStudentEntryData();
    Teacher readTeacherEntryData();
    public long readDomainId();
    long readDomainIdToDelete(int max);
    long readDomainIdToEdit(int max);

    String readDomainName();

    String readDomainSurname();

    String readDomainGender();

    long readDomainAge();

    String readDomainEmail();
    Major readDomainMajor();
    Faculty readFaculty();
    String generateStudentEmail(String name, String surname);
    String generateTeacherEmail(String name, String surname);
}
