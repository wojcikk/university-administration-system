package unisystem.reader.console;

import org.springframework.stereotype.Component;
import unisystem.reader.validation.DefaultInputVerification;
import unisystem.reader.validation.InputVerification;

import java.util.Scanner;

@Component
public class DefaultLoginConsoleReader implements LoginConsoleReader {
    private static final Scanner scanner = new Scanner(System.in);
    private InputVerification inputVerification = new DefaultInputVerification();

    @Override
    public String readLogin() {
        String login;

        do {
            System.out.print("\nEnter login: ");
            login = scanner.nextLine();
        } while(!(inputVerification.checkInputLength(login, 1, 24)));

        return login;
    }

    @Override
    public String readPassword() {
        String password;

        do {
            System.out.print("\nEnter password: ");
            password = scanner.nextLine();
        } while(!(inputVerification.checkInputLength(password, 1, 24)));

        return password;
    }
}
