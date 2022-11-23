package unisystem.reader.file.view;

public interface View {
    void printWelcomeMessage();
    void printStartingApplicationModeOptions();
    void printEntryMenuOptions();

    void printSearchingOptions();
    int selectOption(int maxRange);
    int selectSearchingOption();
    UserView getUserView();
    AdminView getAdminView();
}