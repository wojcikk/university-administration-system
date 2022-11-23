package unisystem.reader.console;

import unisystem.domain.Faculty;
import unisystem.domain.Teacher;

import java.util.List;

public interface TeacherConsoleReader {
    Teacher readTeacherEntryData();
    long readTeacherId();
    long readTeacherIdToDelete(List<Teacher> teachers);
    String readTeacherName();
    String readTeacherSurname();
    String readTeacherGender();
    long readTeacherAge();
    String readTeacherEmail();
    Faculty readTeacherFaculty();

}