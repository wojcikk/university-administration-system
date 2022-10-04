package unisystem.reader.validation;

public interface InputVerification {
    boolean checkTextInput(String input, int min, int max);
    boolean checkNumberOptionInput(int input, int min, int max);
}
