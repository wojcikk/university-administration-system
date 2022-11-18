package unisystem.reader.file;

import unisystem.data.DirPath;
import unisystem.domain.*;

import java.util.ArrayList;
import java.util.List;

public class DefaultTeacherFileReader implements TeacherFileReader {
    private final FileReader reader = new DefaultFileReader();

    @Override
    public List<Teacher> readTeachers() {
        List<Teacher> teachers = new ArrayList<>();

        reader.getReader(DirPath.STUDENTS_FILE_PATH).lines().forEach(line -> {
            String[] lineElements = line.split(",");

            teachers.add(new Teacher(
                    Long.parseLong(lineElements[0]),
                    new Person(
                            lineElements[1],
                            lineElements[2],
                            lineElements[3],
                            Long.parseLong(lineElements[4])
                    ),
                    lineElements[5],
                    new Faculty(lineElements[6], null)
            ));
        });

        reader.closeReader();

        return teachers;
    }
}

