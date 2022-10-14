package unisystem.reader.validation;

public class DefaultInputVerification implements InputVerification {
    @Override
    public boolean checkTextInput(String input) {
        boolean isInputCorrect = true;

        if(!doesTextContainOnlyLetters(input)) {
            System.out.println("Input should contain only letters.");
            isInputCorrect = false;
        }

        return isInputCorrect;
    }

    @Override
    public boolean checkNumberInput(int input, int min, int max) {
        return (input >= min && input <= max);
    }

    @Override
    public boolean checkEmailInput(String input) {
        boolean isInputCorrect = true;

        if(!doesTextContainSpecificCharacter(input, "@")) {
            System.out.println("Input should contain '@'.");
            isInputCorrect = false;
        }

        return isInputCorrect;
    }

    @Override
    public boolean checkInputLength(String input, int min, int max) {
        boolean isInputCorrect = true;

        if(!(input.length() >= min && input.length() <= max)) {
            System.out.println("Input should have been " + min + " and " + max + " characters");
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


}
