package unisystem.application;

import unisystem.view.View;
import unisystem.service.TeacherService;

public interface TeacherServiceRun {
    void runTeacherService(TeacherService teacherService, View view, boolean adminPermission);
}
