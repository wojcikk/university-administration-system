package unisystem.view;

public interface View {
    void printWelcomeMessage();
    void printStartingApplicationModeOptions();
    void printEntryMenuOptions();

    void printSearchingOptions();
    void printStudentEditOptions();
    void printTeacherEditOptions();
    int selectOption(int maxRange);
    int selectSearchingOption();
    int selectStudentEditingOption();
    int selectTeacherEditingOption();
    UserView getUserView();
    AdminView getAdminView();
}