package unisystem.service.search;

import unisystem.domain.Domain;

import java.util.List;

public interface TeacherSearchService {
    Domain searchTeacherById();
    List<Domain> searchTeacherByName();
    List<Domain> searchTeacherBySurname();
    List<Domain> searchTeacherByGender();
    List<Domain> searchTeacherByAge();
    List<Domain> searchTeacherByEmail();
}
