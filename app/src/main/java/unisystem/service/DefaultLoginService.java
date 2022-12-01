package unisystem.service;

import org.springframework.stereotype.Service;
import unisystem.data.DataStore;
import unisystem.domain.User;
import unisystem.reader.console.DefaultLoginConsoleReader;
import unisystem.reader.console.LoginConsoleReader;

@Service
public class DefaultLoginService implements LoginService {
    private final LoginConsoleReader loginConsoleReader;
    private final DataStore dataStore;

    public DefaultLoginService(DataStore dataStore) {
        this.loginConsoleReader = new DefaultLoginConsoleReader();
        this.dataStore = dataStore;
    }

    @Override
    public User authenticate() {

        String login = loginConsoleReader.readLogin();
        String password = loginConsoleReader.readPassword();

        for(User user : dataStore.getUsers()) {
            if(user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return user;
            }
        }

        System.out.println("User did not found!");

        return null;
    }
}
