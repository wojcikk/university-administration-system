package unisystem.service.edit;

import unisystem.domain.Student;
import unisystem.domain.Teacher;
import unisystem.domain.User;
import unisystem.repository.CentralRepository;

public class DefaultUserEditService implements UserEditService {
    private final CentralRepository centralRepository;

    public DefaultUserEditService(CentralRepository centralRepository) {
        this.centralRepository = centralRepository;
    }

    @Override
    public void updateStudentUserEmail(User user, Student student) {
        user.setEmail(student.getEmail());
    }

    @Override
    public void updateTeacherUserEmail(User user, Teacher teacher) {
        user.setEmail(teacher.getEmail());
    }
}
