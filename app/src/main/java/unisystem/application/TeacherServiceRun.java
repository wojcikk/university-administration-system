package unisystem.application;

import unisystem.reader.file.view.View;
import unisystem.service.TeacherService;

public interface TeacherServiceRun {
    void runTeacherService(TeacherService teacherService, View view, boolean adminPermission);
}
