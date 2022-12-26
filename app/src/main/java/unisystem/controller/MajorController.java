package unisystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Major> listAllMajors() {
        return majorService.getMajors();
    }

}
