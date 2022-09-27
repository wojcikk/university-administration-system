package unisystem;

import unisystem.data.DataStore;
import unisystem.data.FileDataStore;

public class Application {
    public static void main(String[] args) {
        run();
    }

    private static void run() {
        DataStore dataStore = new FileDataStore();
        dataStore.init();

        dataStore.getStudents().forEach(System.out::println);
    }
}