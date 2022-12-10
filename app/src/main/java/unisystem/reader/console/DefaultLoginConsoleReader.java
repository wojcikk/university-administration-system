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
    public String readEmail() {
        String email;

        do {
            System.out.print("\nEnter email: ");
            email = scanner.nextLine();
        } while(!(inputVerification.checkEmailInput(email) && inputVerification.checkInputLength(email, 1, 24)));

        return email;
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
