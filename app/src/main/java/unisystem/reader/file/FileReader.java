package unisystem.reader.file;

import java.io.BufferedReader;

public interface FileReader {
    BufferedReader getReader(String filePath);
    void closeReader();
}
