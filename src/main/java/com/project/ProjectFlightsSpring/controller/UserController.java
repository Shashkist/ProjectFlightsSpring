package com.project.ProjectFlightsSpring.controller;

import com.project.ProjectFlightsSpring.data.UserRepository;
import com.project.ProjectFlightsSpring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepo;

    @GetMapping("/register/")
    public String goToUserRegistration() {
        return "registrationForm";
    }

    @PostMapping("/register/")
    public String processRegistration(User user, RedirectAttributes redirectAttributes) {
        userRepo.save(user);
        redirectAttributes.addFlashAttribute("registeredUser", user);
        return "redirect:/api/flight/";
    }
}
