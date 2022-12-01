package unisystem.reader.file;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;

@Component
public class DefaultFileReader implements FileReader {
    private BufferedReader reader;

    @Override
    public BufferedReader getReader(String filePath) {
        try {
            reader = new BufferedReader(new java.io.FileReader(filePath));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return reader;
    }
    @Override
    public void closeReader() {
        try {
            reader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
