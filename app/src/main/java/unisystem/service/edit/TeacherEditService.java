package unisystem.service.edit;

import unisystem.domain.Teacher;

public interface TeacherEditService {
    void editTeacher(Teacher teacher);
    void editTeacherName(Teacher teacher);
    void editTeacherSurname(Teacher teacher);
    void editTeacherGender(Teacher teacher);
    void editTeacherAge(Teacher teacher);
    void editTeacherFaculty(Teacher teacher);
}
