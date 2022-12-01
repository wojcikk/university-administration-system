package unisystem.application;

import org.springframework.stereotype.Component;

@Component
public class ApplicationServiceRun implements ServiceRun{
    private final StudentServiceRun studentServiceRun;
    private final UniStructureServiceRun uniStructureServiceRun;
    private final TeacherServiceRun teacherServiceRun;

    public ApplicationServiceRun() {
        this.studentServiceRun = new ApplicationStudentServiceRun();
        this.uniStructureServiceRun = new ApplicationUniStructureServiceRun();
        this.teacherServiceRun = new ApplicationTeacherServiceRun();
    }

    @Override
    public StudentServiceRun getStudentServiceRun() {
        return studentServiceRun;
    }

    @Override
    public UniStructureServiceRun getUniStructureServiceRun() {
        return uniStructureServiceRun;
    }

    @Override
    public TeacherServiceRun getTeacherServiceRun() {
        return teacherServiceRun;
    }
}