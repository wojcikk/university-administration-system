package unisystem.service;

import org.springframework.stereotype.Service;
import unisystem.domain.Entitlements;
import unisystem.domain.User;
import unisystem.reader.console.DefaultLoginConsoleReader;
import unisystem.reader.console.LoginConsoleReader;
import unisystem.repository.CentralRepository;

import java.util.List;
import java.util.Random;

@Service
public class DefaultUserService implements UserService {
    private final LoginConsoleReader loginConsoleReader;
    private final CentralRepository centralRepository;

    public DefaultUserService(CentralRepository centralRepository) {
        this.loginConsoleReader = new DefaultLoginConsoleReader();
        this.centralRepository = centralRepository;
    }

    @Override
    public List<User> getUsers() {
        return this.centralRepository.getUserRepository().findAll();
    }

    @Override
    public User authenticate() {

        String email = loginConsoleReader.readEmail();
        String password = loginConsoleReader.readPassword();

        for(User user : centralRepository.getUserRepository().findAll()) {
            if(user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            }
        }

        System.out.println("User did not found!");

        System.exit(0);

        return null;
    }

    @Override
    public void addUser(String email, Entitlements entitlements) {
        boolean correctPassword = false;
        String password = null;

        while(!correctPassword) {
            correctPassword = true;
            password = generatePassword(8);
            for (User user : this.centralRepository.getUserRepository().findAll()) {
                if (user.getPassword().equals(password)) {
                    correctPassword = false;
                    break;
                }
            }
        }

        User user = new User(email, password, entitlements);

        System.out.println("User saved: " + user.toString());

        this.centralRepository.getUserRepository().save(user);
    }

    @Override
    public void deleteUser(String email) {
        for (User user : this.centralRepository.getUserRepository().findAll()) {
            if (user.getEmail().equals(email)) {
                this.centralRepository.getUserRepository().delete(user);
            }
        }
    }

    @Override
    public User findUserByEmail(String email) {
        for (User user : this.centralRepository.getUserRepository().findAll()) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }

        System.out.println("User did not found!");

        System.exit(0);

        return null;
    }

    private String generatePassword(int length) {
        String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String specialCharacters = "!@#$";
        String numbers = "1234567890";
        String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for(int i = 0; i < length ; i++) {
            password.append(combinedChars.charAt(random.nextInt(combinedChars.length())));
        }

        return password.toString();
    }
}
