package unisystem.service;

import org.springframework.stereotype.Service;
import unisystem.data.DataStore;

@Service
public class DefaultMajorService implements MajorService {
    private final DataStore dataStore;

    public DefaultMajorService(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public void listAllMajors() {
        dataStore.getMajors().forEach(major -> {
            System.out.printf("%-5s %-20s %-20s %-40s\n",
                    major.getId(),
                    major.getFieldOfStudy().getName(),
                    major.getDegree().getName(),
                    major.getFaculty().getName());
        });
    }

    @Override
    public void listAllFieldsOfStudy() {
        System.out.printf("%-5s %-20s\n",
                "ID", "NAME"
        );

        dataStore.getFieldsOfStudies().forEach(fieldOfStudy -> {
            System.out.printf("%-5s %-20s\n",
                    fieldOfStudy.getId(),
                    fieldOfStudy.getName());
        });
    }


    @Override
    public void listAllDegrees() {
        System.out.printf("%-5s %-20s\n",
                "ID", "NAME"
        );
        dataStore.getDegrees().forEach(degree -> {
            System.out.printf("%-5s %-20s\n",
                    degree.getId(),
                    degree.getName());
        });
    }

    @Override
    public void listAllFaculties() {
        System.out.printf("%-5s %-40s\n",
                "ID", "NAME"
        );
        dataStore.getFaculties().forEach(faculty -> {
            System.out.printf("%-5s %-40s\n",
                    faculty.getId(),
                    faculty.getName());
        });
    }


}
