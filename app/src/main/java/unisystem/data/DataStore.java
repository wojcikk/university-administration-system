package unisystem.data;

import unisystem.domain.*;

import java.util.List;

public interface DataStore {
    void init();

    List<Student> getStudents();
    List<Major> getMajors();
    List<FieldOfStudy> getFieldsOfStudies();
    List<Degree> getDegrees();
    List<Faculty> getFaculties();
}
