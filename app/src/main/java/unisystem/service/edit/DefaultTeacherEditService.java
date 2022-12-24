package unisystem.service.edit;

import unisystem.domain.Faculty;
import unisystem.domain.Teacher;
import unisystem.reader.console.DefaultDomainConsoleReader;
import unisystem.reader.console.DomainConsoleReader;
import unisystem.repository.CentralRepository;

public class DefaultTeacherEditService implements TeacherEditService {

    private final DomainConsoleReader domainConsoleReader;

    public DefaultTeacherEditService(CentralRepository centralRepository) {
        this.domainConsoleReader = new DefaultDomainConsoleReader(centralRepository);
    }

    @Override
    public void editTeacher(Teacher teacher) {
        Teacher newTeacher = domainConsoleReader.readTeacherEntryData();

        teacher.setName(newTeacher.getName());
        teacher.setSurname(newTeacher.getSurname());
        teacher.setGender(newTeacher.getGender());
        teacher.setAge(newTeacher.getAge());
        teacher.setFaculty(newTeacher.getFaculty());

        String newEmail = domainConsoleReader.generateTeacherEmail(teacher.getName(), teacher.getSurname());

        teacher.setEmail(newEmail);
    }

    @Override
    public void editTeacherName(Teacher teacher) {
        String newName = domainConsoleReader.readDomainName();

        String newEmail = domainConsoleReader.generateStudentEmail(newName, teacher.getSurname());

        teacher.setName(newName);
        teacher.setEmail(newEmail);
    }

    @Override
    public void editTeacherSurname(Teacher teacher) {
        String newSurname = domainConsoleReader.readDomainSurname();

        String newEmail = domainConsoleReader.generateStudentEmail(teacher.getName(), newSurname);

        teacher.setSurname(newSurname);
        teacher.setEmail(newEmail);
    }

    @Override
    public void editTeacherGender(Teacher teacher) {
        String newGender = domainConsoleReader.readDomainGender();

        teacher.setGender(newGender);
    }

    @Override
    public void editTeacherAge(Teacher teacher) {
        long newAge = domainConsoleReader.readDomainAge();

        teacher.setAge(newAge);
    }

    @Override
    public void editTeacherFaculty(Teacher teacher) {
        Faculty newFaculty = domainConsoleReader.readFaculty();

        teacher.setFaculty(newFaculty);
    }
}
