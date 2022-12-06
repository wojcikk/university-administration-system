package unisystem.service;

import org.springframework.stereotype.Service;
import unisystem.domain.User;
import unisystem.reader.console.DefaultLoginConsoleReader;
import unisystem.reader.console.LoginConsoleReader;
import unisystem.repository.CentralRepository;

@Service
public class DefaultLoginService implements LoginService {
    private final LoginConsoleReader loginConsoleReader;
    private final CentralRepository centralRepository;

    public DefaultLoginService(CentralRepository centralRepository) {
        this.loginConsoleReader = new DefaultLoginConsoleReader();
        this.centralRepository = centralRepository;
    }

    @Override
    public User authenticate() {

        String login = loginConsoleReader.readLogin();
        String password = loginConsoleReader.readPassword();

        for(User user : centralRepository.getUserRepository().findAll()) {
            if(user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return user;
            }
        }

        System.out.println("User did not found!");

        System.exit(0);

        return null;
    }
}
