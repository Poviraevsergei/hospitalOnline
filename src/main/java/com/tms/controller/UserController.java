package com.tms.controller;

import com.tms.domain.User;
import com.tms.exception.UserNotFoundException;
import com.tms.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
@RequestMapping("/user")
public class UserController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable int id, ModelMap model) throws UserNotFoundException {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "userJSP";
    }

    @GetMapping
    public String getAllUsers(ModelMap model) {
        ArrayList<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "allUsers";
    }

    @PostMapping
    public String createUser(@ModelAttribute @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            for (ObjectError o : bindingResult.getAllErrors()) {
                log.warn(o.getDefaultMessage());
            }
            return "unsuccess";
        }
        int result = userService.createUser(user);
        return result > 0 ? "success" : "unsuccess";
    }

    @PutMapping
    @ResponseBody
    public String updateUserById(@RequestParam int id,
                                 @RequestParam String firstName,
                                 @RequestParam String lastName,
                                 @RequestParam int age,
                                 @RequestParam String login,
                                 @RequestParam String password) {
        int result = userService.updateUserById(id, firstName, lastName, age, login, password);
        return result > 0 ? "User was updated!" : "User wasn't updated!";
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public String delete(@PathVariable int id) {
        int result = userService.deleteUserById(id);
        return result > 0 ? "User was deleted!" : "User wasn't deleted!";
    }
}