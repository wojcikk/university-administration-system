package unisystem.reader.console;

import unisystem.domain.Major;
import unisystem.domain.Student;

import java.util.List;

public interface StudentConsoleReader {
    Student readStudentEntryData();
    public long readStudentId();
    long readStudentIdToDelete(List<Student> students);

    String readStudentName();

    String readStudentSurname();

    String readStudentGender();

    long readStudentAge();

    String readStudentEmail();
    Major readStudentMajor();
}
