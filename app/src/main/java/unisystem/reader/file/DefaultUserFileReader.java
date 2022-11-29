package unisystem.reader.file;

import unisystem.data.DirPath;
import unisystem.domain.*;

import java.util.ArrayList;
import java.util.List;

public class DefaultUserFileReader implements UserFileReader {
    private final FileReader reader = new DefaultFileReader();

    @Override
    public List<User> readUsers() {
        List<User> users = new ArrayList<>();

        reader.getReader(DirPath.USERS_FILE_PATH).lines().forEach(line -> {
            String[] lineElements = line.split(",");

            users.add(new User(
                    Long.parseLong(lineElements[0]),
                    lineElements[1],
                    lineElements[2],
                    Entitlements.valueOf(lineElements[3])
            ));
        });

        reader.closeReader();

        return users;
    }
}
