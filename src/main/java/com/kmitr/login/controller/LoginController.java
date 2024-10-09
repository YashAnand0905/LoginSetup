package com.kmitr.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.kmitr.login.entity.User;
import com.kmitr.login.service.UserService;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Returns the login HTML page
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        User user = userService.authenticate(username, password);
        if (user != null) {
            model.addAttribute("username", user.getUsername());
            return "welcome"; // Redirects to the welcome page upon successful login
        } else {
            model.addAttribute("error", "Invalid credentials");
            return "login"; // Returns to login page if authentication fails
        }
    }
}
