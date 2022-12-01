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
                    Long.parseLong(lineElements[0]),
                    new Person(
                            lineElements[1],
                            lineElements[2],
                            lineElements[3],
                            Long.parseLong(lineElements[4])
                    ),
                    lineElements[5],
                    new Major(
                            new FieldOfStudy(lineElements[6]),
                            new Degree(lineElements[7]),
                            new Faculty(lineElements[8], null)
                    )
            ));
        });

        reader.closeReader();

        return students;
    }
}
