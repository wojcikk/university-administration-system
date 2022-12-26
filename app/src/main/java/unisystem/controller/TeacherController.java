package unisystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import unisystem.domain.Teacher;
import unisystem.service.TeacherService;

import java.util.List;

@RestController
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @RequestMapping(value = "/teachers/all", method = RequestMethod.GET)
    public ResponseEntity<List<Teacher>> listAllTeachers() {
        List<Teacher> teachers = teacherService.getTeachers();
        return new ResponseEntity<>(teachers, HttpStatus.OK);
    }
}
