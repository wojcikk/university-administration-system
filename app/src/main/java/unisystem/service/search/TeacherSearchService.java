package unisystem.service.search;

import unisystem.domain.Teacher;

import java.util.List;

public interface TeacherSearchService {
    Teacher searchTeacherById();
    List<Teacher> searchTeacherByName();
    List<Teacher> searchTeacherBySurname();
    List<Teacher> searchTeacherByGender();
    List<Teacher> searchTeacherByAge();
    List<Teacher> searchTeacherByEmail();
}
