package unisystem.data;

import unisystem.domain.*;
import unisystem.reader.file.DefaultMajorFileReader;
import unisystem.reader.file.DefaultStudentFileReader;
import unisystem.reader.file.MajorFileReader;
import unisystem.reader.file.StudentFileReader;

import java.util.List;

public class FileDataStore implements DataStore {
    private List<Student> students;
    private List<Major> majors;
    private List<FieldOfStudy> fieldsOfStudies;
    private List<Degree> degrees;
    private List<Faculty> faculties;

    private final StudentFileReader studentFileReader;
    private final MajorFileReader majorFileReader;

    public FileDataStore() {
        this.studentFileReader = new DefaultStudentFileReader();
        this.majorFileReader = new DefaultMajorFileReader();
    }

    @Override
    public void init() {
        this.students = studentFileReader.readStudents();
        this.majors = majorFileReader.readMajors();
        this.fieldsOfStudies = majorFileReader.readFieldsOfStudy();
        this.degrees = majorFileReader.readDegrees();
        this.faculties = majorFileReader.readFaculties();
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
}
