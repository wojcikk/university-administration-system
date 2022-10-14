package unisystem.reader.validation;

public interface InputVerification {
    boolean checkTextInput(String input);
    boolean checkNumberInput(int input, int min, int max);
    boolean checkEmailInput(String input);
    boolean checkInputLength(String input, int min, int max);
}
