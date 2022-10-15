package unisystem.reader.file;

import unisystem.domain.Degree;
import unisystem.domain.Faculty;
import unisystem.domain.FieldOfStudy;
import unisystem.domain.Major;

import java.util.List;

public interface MajorFileReader {
    List<Major> readMajors();
    List<FieldOfStudy> readFieldsOfStudy();
    List<Degree> readDegrees();
    List<Faculty> readFaculties();
}
