package unisystem.reader.validation;

public interface InputVerification {
    boolean checkTextInput(String input, int min, int max);
    boolean checkNumberInput(int input, int min, int max);
    boolean checkEmailInput(String input, int min, int max);
}
