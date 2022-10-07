package unisystem.reader.validation;

public class DefaultInputVerification implements InputVerification {
    @Override
    public boolean checkTextInput(String input, int min, int max) {
        boolean isInputCorrect = true;

        if(!doesTextContainOnlyLetters(input) || !isTextLongCorrect(input, min, max)) {
            System.out.println("Input should contain only letters, and have between " + min + " and " + max + " characters");
            isInputCorrect = false;
        }

        return isInputCorrect;
    }

    @Override
    public boolean checkNumberInput(int input, int min, int max) {
        return (input >= min && input <= max);
    }

    @Override
    public boolean checkEmailInput(String input, int min, int max) {
        boolean isInputCorrect = true;

        if(!doesTextContainSpecificCharacter(input, "@") || !isTextLongCorrect(input, min, max)) {
            System.out.println("Input should contain '@', and have between " + min + " and " + max + " characters");
            isInputCorrect = false;
        }

        return isInputCorrect;
    }

    private boolean doesTextContainOnlyLetters(String text) {
        return text.matches("[a-zA-Z]+");
    }

    private boolean doesTextContainSpecificCharacter(String text, String character) {
        return text.contains(character);
    }

    private boolean isTextLongCorrect(String name, int min, int max) {
        return (name.length() >= min && name.length() <= max);
    }


}
