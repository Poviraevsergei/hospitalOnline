package com.tms.controller;

import com.tms.domain.UserExample;
import com.tms.repository.UserExampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping(value = "/userexample", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserExampleController {

    private final UserExampleRepository userExampleRepository;

    @Autowired
    public UserExampleController(UserExampleRepository userExampleRepository) {
        this.userExampleRepository = userExampleRepository;
    }

    @GetMapping
    public ResponseEntity<ArrayList<UserExample>> getAllUsersEx() {
        return new ResponseEntity<>(userExampleRepository.getAllUserEx(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserExample> getUserById(@PathVariable int id) {
        UserExample user = userExampleRepository.getUserExampleById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}