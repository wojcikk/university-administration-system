package unisystem.data;

import unisystem.domain.*;
import unisystem.reader.file.*;

import java.util.List;

public class FileDataStore implements DataStore {
    private List<Student> students;
    private List<Teacher> teachers;
    private List<Major> majors;
    private List<FieldOfStudy> fieldsOfStudies;
    private List<Degree> degrees;
    private List<Faculty> faculties;


    private final StudentFileReader studentFileReader;
    private final MajorFileReader majorFileReader;
    private final TeacherFileReader teacherFileReader;

    public FileDataStore() {
        this.studentFileReader = new DefaultStudentFileReader();
        this.majorFileReader = new DefaultMajorFileReader();
        this.teacherFileReader = new DefaultTeacherFileReader();
    }

    @Override
    public void init() {
        this.students = studentFileReader.readStudents();
        this.majors = majorFileReader.readMajors();
        this.fieldsOfStudies = majorFileReader.readFieldsOfStudy();
        this.degrees = majorFileReader.readDegrees();
        this.faculties = majorFileReader.readFaculties();
        this.teachers = teacherFileReader.readTeachers();
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
}
