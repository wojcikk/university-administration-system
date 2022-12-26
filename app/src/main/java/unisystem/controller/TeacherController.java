package unisystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Teacher> listAllTeachers() {
        return teacherService.getTeachers();
    }

}
