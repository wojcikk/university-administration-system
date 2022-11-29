package unisystem.data;

import unisystem.domain.*;
import unisystem.reader.file.DefaultUserFileReader;
import unisystem.reader.file.*;

import java.util.List;

public class FileDataStore implements DataStore {
    private List<Student> students;
    private List<Teacher> teachers;
    private List<Major> majors;
    private List<FieldOfStudy> fieldsOfStudies;
    private List<Degree> degrees;
    private List<Faculty> faculties;
    private List<User> users;


    private final StudentFileReader studentFileReader;
    private final MajorFileReader majorFileReader;
    private final TeacherFileReader teacherFileReader;
    private final UserFileReader userFileReader;

    public FileDataStore() {
        this.studentFileReader = new DefaultStudentFileReader();
        this.majorFileReader = new DefaultMajorFileReader();
        this.teacherFileReader = new DefaultTeacherFileReader();
        this.userFileReader = new DefaultUserFileReader();
    }

    @Override
    public void init() {
        this.students = studentFileReader.readStudents();
        this.majors = majorFileReader.readMajors();
        this.fieldsOfStudies = majorFileReader.readFieldsOfStudy();
        this.degrees = majorFileReader.readDegrees();
        this.faculties = majorFileReader.readFaculties();
        this.teachers = teacherFileReader.readTeachers();
        this.users = userFileReader.readUsers();
    }

    @Override
    public List<Student> getStudents() {
        return this.students;
    }

    @Override
    public List<Major> getMajors() {
        return this.majors;
    }

    @Override
    public List<FieldOfStudy> getFieldsOfStudies() {
        return this.fieldsOfStudies;
    }

    @Override
    public List<Degree> getDegrees() {
        return this.degrees;
    }

    @Override
    public List<Faculty> getFaculties() {
        return this.faculties;
    }

    @Override
    public List<Teacher> getTeachers() {
        return this.teachers;
    }

    @Override
    public List<User> getUsers() {
        return this.users;
    }
}
