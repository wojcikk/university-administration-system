package unisystem.reader.file;

import unisystem.data.DirPath;
import unisystem.domain.Degree;
import unisystem.domain.Faculty;
import unisystem.domain.FieldOfStudy;
import unisystem.domain.Major;

import java.util.ArrayList;
import java.util.List;

public class DefaultMajorFileReader implements MajorFileReader {
    private final FileReader reader = new DefaultFileReader();

    @Override
    public List<Major> readMajors() {
        List<Major> majors = new ArrayList<>();

        reader.getReader(DirPath.MAJORS_FILE_PATH).lines().forEach(line -> {
            String[] lineElements = line.split(",");

            majors.add(new Major(
                    Long.parseLong(lineElements[0]),
                    new FieldOfStudy(lineElements[1]),
                    new Degree(lineElements[2]),
                    new Faculty(lineElements[3], null)
            ));
        });

        reader.closeReader();

        return majors;
    }

    @Override
    public List<FieldOfStudy> readFieldsOfStudy() {
        List<FieldOfStudy> fieldsOfStudy = new ArrayList<>();

        reader.getReader(DirPath.FIELDS_OF_STUDY_FILE_PATH).lines().forEach(line -> {
            String[] lineElements = line.split(",");

            fieldsOfStudy.add(new FieldOfStudy(
                    Long.parseLong(lineElements[0]),
                    lineElements[1]
            ));
        });

        reader.closeReader();

        return fieldsOfStudy;
    }

    @Override
    public List<Degree> readDegrees() {
        List<Degree> degrees = new ArrayList<>();

        reader.getReader(DirPath.DEGREES_FILE_PATH).lines().forEach(line -> {
            String[] lineElements = line.split(",");

            degrees.add(new Degree(
                    Long.parseLong(lineElements[0]),
                    lineElements[1]
            ));
        });

        reader.closeReader();

        return degrees;
    }

    @Override
    public List<Faculty> readFaculties() {
        List<Faculty> faculties = new ArrayList<>();

        reader.getReader(DirPath.FACULTIES_FILE_PATH).lines().forEach(line -> {
            String[] lineElements = line.split(",");

            faculties.add(new Faculty(
                    Long.parseLong(lineElements[0]),
                    lineElements[1],
                    lineElements[2]
            ));
        });

        reader.closeReader();

        return faculties;
    }
}
