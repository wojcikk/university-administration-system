package unisystem.service.search;

import unisystem.domain.Domain;

import java.util.List;

public interface StudentSearchService {
    Domain searchStudentById();
    List<Domain> searchStudentByName();
    List<Domain> searchStudentBySurname();
    List<Domain> searchStudentByGender();
    List<Domain> searchStudentByAge();
    List<Domain> searchStudentByEmail();
}
