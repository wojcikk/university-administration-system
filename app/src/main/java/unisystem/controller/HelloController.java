package unisystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import unisystem.domain.Major;
import unisystem.domain.Student;
import unisystem.service.MajorService;
import unisystem.service.StudentService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HelloController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private MajorService majorService;

    @GetMapping("/")
    public String viewHomePage() {
        return "index";
    }
    @GetMapping("/studentService")
    public String viewStudentService(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("majors", majorService.getMajors());
        model.addAttribute("listStudents", studentService.getStudents());
        return "studentService";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") Student student) {
        // save employee to database
        studentService.addStudent(student);
        return "redirect:/studentService";
    }

    @GetMapping("/studentService/showNewStudentForm")
    public String showNewStudentForm(Model model) {
        // create model attribute to bind form data
        Student student = new Student();
        model.addAttribute("student", student);
        model.addAttribute("majors", majorService.getMajors());
        model.addAttribute("listStudents", studentService.getStudents());
        return "/new_student";
    }

    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable(value = "id") long id, Model model) {
        model.addAttribute("listStudents", studentService.getStudents());

        // call delete employee method
        this.studentService.deleteStudentById(id);
        return "redirect:/studentService";
    }

    @ModelAttribute("getAllMajors")
    public List<Major> getAllMajors() {
        return majorService.getMajors();
    }
}