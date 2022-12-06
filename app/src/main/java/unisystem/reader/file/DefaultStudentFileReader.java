package unisystem.reader.file;

import org.springframework.stereotype.Component;
import unisystem.data.DirPath;
import unisystem.domain.*;

import java.util.ArrayList;
import java.util.List;

@Component
public class DefaultStudentFileReader implements StudentFileReader {
    private final FileReader reader = new DefaultFileReader();

    @Override
    public List<Student> readStudents() {
        List<Student> students = new ArrayList<>();

        reader.getReader(DirPath.STUDENTS_FILE_PATH).lines().forEach(line -> {
            String[] lineElements = line.split(",");

            students.add(new Student(
                    lineElements[1],
                    lineElements[2],
                    lineElements[3],
                    Long.parseLong(lineElements[4]),
                    Long.parseLong(lineElements[0]),
                    lineElements[5],
                    null
            ));
        });

        reader.closeReader();

        return students;
    }
}
