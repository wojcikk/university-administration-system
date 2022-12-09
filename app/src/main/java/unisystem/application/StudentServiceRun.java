package unisystem.application;

import unisystem.view.View;
import unisystem.service.StudentService;

public interface StudentServiceRun {
    void runStudentService(StudentService studentService, View view, boolean adminPermission);
}
