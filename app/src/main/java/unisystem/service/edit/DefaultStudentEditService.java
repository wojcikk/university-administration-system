package unisystem.service.edit;

import unisystem.domain.Major;
import unisystem.domain.Student;
import unisystem.reader.console.DefaultDomainConsoleReader;
import unisystem.reader.console.DomainConsoleReader;
import unisystem.repository.CentralRepository;

public class DefaultStudentEditService implements StudentEditService{
    private final DomainConsoleReader domainConsoleReader;

    public DefaultStudentEditService(CentralRepository centralRepository) {
        this.domainConsoleReader = new DefaultDomainConsoleReader(centralRepository);
    }

    @Override
    public void editStudent(Student student) {
        Student newStudent = domainConsoleReader.readStudentEntryData();

        student.setName(newStudent.getName());
        student.setSurname(newStudent.getSurname());
        student.setGender(newStudent.getGender());
        student.setAge(newStudent.getAge());
        student.setMajor(newStudent.getMajor());

        String newEmail = domainConsoleReader.generateStudentEmail(student.getName(), student.getSurname());

        student.setEmail(newEmail);
    }

    @Override
    public void editStudentName(Student student) {
        String newName = domainConsoleReader.readDomainName();

        String newEmail = domainConsoleReader.generateStudentEmail(newName, student.getSurname());

        student.setName(newName);
        student.setEmail(newEmail);
    }

    @Override
    public void editStudentSurname(Student student) {
        String newSurname = domainConsoleReader.readDomainSurname();

        String newEmail = domainConsoleReader.generateStudentEmail(student.getName(), newSurname);

        student.setSurname(newSurname);
        student.setEmail(newEmail);
    }

    @Override
    public void editStudentGender(Student student) {
        String newGender = domainConsoleReader.readDomainGender();

        student.setGender(newGender);
    }

    @Override
    public void editStudentAge(Student student) {
        long newAge = domainConsoleReader.readDomainAge();

        student.setAge(newAge);
    }

    @Override
    public void editStudentMajor(Student student) {
        Major newMajor = domainConsoleReader.readDomainMajor();

        student.setMajor(newMajor);
    }
}
