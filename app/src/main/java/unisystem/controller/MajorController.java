package unisystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import unisystem.domain.Major;
import unisystem.service.MajorService;

import java.util.List;

@RestController
public class MajorController {
    @Autowired
    private MajorService majorService;

    @RequestMapping(value = "/majors/all", method = RequestMethod.GET)
    public ResponseEntity<List<Major>> listAllMajors() {
        List<Major> majors =  majorService.getMajors();
        return new ResponseEntity<>(majors, HttpStatus.OK);
    }

}
