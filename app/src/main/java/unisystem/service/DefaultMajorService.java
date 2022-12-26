package unisystem.service;

import org.springframework.stereotype.Service;
import unisystem.domain.Major;
import unisystem.repository.CentralRepository;

import java.util.List;

@Service
public class DefaultMajorService implements MajorService {
    private final CentralRepository centralRepository;

    public DefaultMajorService(CentralRepository centralRepository) {
        this.centralRepository = centralRepository;
    }

    @Override
    public List<Major> getMajors() {
        return this.centralRepository.getMajorRepository().findAll();
    }

    @Override
    public void listAllMajors() {
        centralRepository.getMajorRepository().findAll().forEach(major -> {
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

        centralRepository.getFieldOfStudyRepository().findAll().forEach(fieldOfStudy -> {
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
        centralRepository.getDegreeRepository().findAll().forEach(degree -> {
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
        centralRepository.getFacultyRepository().findAll().forEach(faculty -> {
            System.out.printf("%-5s %-40s\n",
                    faculty.getId(),
                    faculty.getName());
        });
    }


}
