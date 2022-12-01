package unisystem.reader.console;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class DefaultConsoleReader implements ConsoleReader {
    private static final Scanner scanner = new Scanner(System.in);

    public int readInteger() {
        int input = 0;

        try {
            input = Integer.parseInt(scanner.next());
        }
        catch(NumberFormatException e) {
            System.out.println("Invalid input!");
        }

        return input;
    }
}
