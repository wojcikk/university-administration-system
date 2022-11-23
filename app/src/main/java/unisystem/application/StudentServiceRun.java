package unisystem.application;

import unisystem.reader.file.view.View;
import unisystem.service.StudentService;

public interface StudentServiceRun {
    void runStudentService(StudentService studentService, View view, boolean adminPermission);
}
