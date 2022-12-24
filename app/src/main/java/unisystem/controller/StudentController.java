package unisystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import unisystem.domain.Student;
import unisystem.service.StudentService;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/getStudents", method = RequestMethod.GET)
    public List<Student> listStudents() {
        return studentService.getStudents();
    }

}
