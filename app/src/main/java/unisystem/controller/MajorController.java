package unisystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unisystem.domain.Major;
import unisystem.service.MajorService;

import java.util.List;

@RestController
@RequestMapping("/majors")
public class MajorController {
    @Autowired
    private MajorService majorService;

    @GetMapping("/all")
    public ResponseEntity<List<Major>> listAllMajors() {
        List<Major> majors =  majorService.getMajors();
        return new ResponseEntity<>(majors, HttpStatus.OK);
    }

}
