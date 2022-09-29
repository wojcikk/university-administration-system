package unisystem.data;

import unisystem.domain.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileDataStore implements DataStore {
    private final List<Student> students;
    private BufferedReader reader;

    public FileDataStore() {
        this.students =  new ArrayList<>();
    }

    public void init() {
        readStudents();
    }

    @Override
    public List<Student> readStudents() {

        getReader(DirPath.DIR_PATH).lines().forEach(line -> {
            String[] lineElements = line.split(",");

            this.students.add(new Student(
                    Long.parseLong(lineElements[0]),
                    lineElements[1],
                    lineElements[2],
                    lineElements[3],
                    Long.parseLong(lineElements[4]),
                    lineElements[5]
            ));
        });

        closeReader();

        return this.students;
    }

    private BufferedReader getReader(String filePath) {
        try {
            reader = new BufferedReader(new FileReader(filePath));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return reader;
    }

    private void closeReader() {
        try {
            reader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Student> getStudents() {
        return students;
    }
}
