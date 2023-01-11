package unisystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unisystem.domain.Student;
import unisystem.service.StudentService;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/students/all", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> students = studentService.getStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @RequestMapping(value = "/students/find/{id}", method = RequestMethod.GET)
    public ResponseEntity<Student> getStudentById(@PathVariable(value = "id") Long studentId) {
        Student student = studentService.findStudentById(studentId);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @RequestMapping(value = "/students/add", method = RequestMethod.POST)
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student newStudent = studentService.addStudent(student);
        return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/students/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Student> updateStudent(@PathVariable long id,@RequestBody Student newStudentDetails) {
        Student updateStudent = this.studentService.updateStudent(id, newStudentDetails);

        return new ResponseEntity<>(updateStudent, HttpStatus.OK);
    }

    @RequestMapping(value = "/students/delete/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> deleteStudentById(@PathVariable(value = "id") Long studentId) {
        studentService.deleteStudentById(studentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
