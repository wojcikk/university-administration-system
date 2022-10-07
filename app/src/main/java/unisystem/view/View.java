package unisystem.view;

public interface View {
    void printWelcomeMessage();
    void printMenuOptions();
    void printSearchingOptions();
    int selectOption();
    int selectSearchingOption();
}
