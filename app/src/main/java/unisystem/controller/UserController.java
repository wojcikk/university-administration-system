package unisystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import unisystem.domain.User;
import unisystem.service.UserService;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users/all", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAllUsers() {
        List<User> users =  userService.getUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
