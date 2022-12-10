package unisystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import unisystem.application.ApplicationServiceRun;
import unisystem.application.ServiceRun;
import unisystem.view.CLIView;
import unisystem.view.View;
import unisystem.repository.*;
import unisystem.service.*;

@Component
public class UniSystem implements CommandLineRunner {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    MajorRepository majorRepository;
    @Autowired
    DegreeRepository degreeRepository;
    @Autowired
    FacultyRepository facultyRepository;
    @Autowired
    FieldOfStudyRepository fieldOfStudyRepository;
    @Autowired
    TeacherRepository teacherRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
//        DataStore dataStore = new FileDataStore();
//        dataStore.init();

        CentralRepository centralRepository = new DefaultCentralRepository(studentRepository, majorRepository, degreeRepository, facultyRepository, fieldOfStudyRepository, teacherRepository, userRepository);


        StudentService studentService = new DefaultStudentService(centralRepository);
        MajorService majorService = new DefaultMajorService(centralRepository);
        TeacherService teacherService = new DefaultTeacherService(centralRepository);

        UserService userService = new DefaultUserService(centralRepository);

        View view = new CLIView();

        //User user = loginService.authenticate();


        view.printWelcomeMessage();

        //if (user.getEntitlements().equals(Entitlements.USER)) {    // user
        //    System.out.println("::: USER MODE :::");
        //    runServiceOptions(studentService, majorService, teacherService, view, false);
        //} else if (user.getEntitlements().equals(Entitlements.ADMIN)) {   // admin
            int decision = 1;
            while(decision != 0 ) {
                view.printStartingApplicationModeOptions();
                decision = view.selectOption(2);
                if(decision == 1) {
                    System.out.println("\n::: USER MODE :::\n");
                    runServiceOptions(studentService, majorService, teacherService, view, false);
                } else if(decision == 2) {
                    System.out.println("\n::: ADMIN MODE :::\n");
                    runServiceOptions(studentService, majorService, teacherService, view, true);
                }
            }
            System.exit(0);
        //}



    }

    private static void runServiceOptions(StudentService studentService, MajorService majorService, TeacherService teacherService, View view, boolean adminPermission) {
        ServiceRun applicationServiceRun = new ApplicationServiceRun();

        int decision = 1;
        while(decision != 0) {
            view.printEntryMenuOptions();
            decision = view.selectOption(3);

            if (decision == 1) {
                applicationServiceRun.getStudentServiceRun().runStudentService(studentService, view, adminPermission);
            } else if (decision == 2) {
                applicationServiceRun.getUniStructureServiceRun().runUniStructureService(majorService, view, adminPermission);
            } else if (decision == 3) {
                applicationServiceRun.getTeacherServiceRun().runTeacherService(teacherService, view, adminPermission);
            }
        }
    }


}