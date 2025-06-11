package com.example.backend_api.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private UserService userService;

    @GetMapping("/customers")
    public String customersPage(Model model) {
        List<User> customers = userService.getAllUsers(); // implement this method
        Long providerId = 1L; // get from session, authentication, or pass as needed
        model.addAttribute("customers", customers);
        model.addAttribute("providerId", providerId);
        return "customers";
    }
}
