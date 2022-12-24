package unisystem.service.edit;

import unisystem.domain.Student;
import unisystem.domain.Teacher;
import unisystem.domain.User;

public interface UserEditService {
    void updateStudentUserEmail(User user, Student student);
    void updateTeacherUserEmail(User user, Teacher teacher);
}
