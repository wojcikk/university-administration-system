package unisystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unisystem.domain.Teacher;
import unisystem.service.TeacherService;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping("/all")
    public ResponseEntity<List<Teacher>> listAllTeachers() {
        List<Teacher> teachers = teacherService.getTeachers();
        return new ResponseEntity<>(teachers, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable(value = "id") Long teacherId) {
        Teacher teacher = teacherService.findTeacherById(teacherId);
        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Teacher> addTeacher(@RequestBody Teacher teacher) {
        Teacher newTeacher = teacherService.addTeacher(teacher);
        return new ResponseEntity<>(newTeacher, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable long id,@RequestBody Teacher newTeacherDetails) {
        Teacher updateTeacher = this.teacherService.updateTeacher(id, newTeacherDetails);

        return new ResponseEntity<>(updateTeacher, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> deleteTeacherById(@PathVariable(value = "id") Long studentId) {
        teacherService.deleteTeacherById(studentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
