package unisystem.view;

public interface View {
    void printWelcomeMessage();
    void printEntryMenuOptions();
    void printStudentMenuOptions();
    void printTeacherMenuOptions();
    void printUniStructureMenuOptions();
    void printSearchingOptions();
    int selectOption();
    int selectSearchingOption();
}
