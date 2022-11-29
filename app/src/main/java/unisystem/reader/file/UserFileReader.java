package unisystem.reader.file;

import unisystem.domain.User;

import java.util.List;

public interface UserFileReader {
    List<User> readUsers();
}
