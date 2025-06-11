package com.example.backend_api.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SignUpController {

    @Autowired
    private UserService userService;

    @GetMapping("/signup")
    public String showSignupForm() {
        // This renders src/main/resources/templates/signup.ftlh
        return "signup";
    }

    @PostMapping("/signup")
    public String processSignup(@RequestParam String email,
                                @RequestParam String password) {

        // Create new User with email and password (you can add username later)
        User user = new User();
        user.setEmail(email);
        user.setUsername(email); // simple default username
        user.setPassword(password); // In production, hash this!

        userService.createUser(user);

        // Redirect to login or homepage after signup success
        return "redirect:/dashboard"; 
    }
    @GetMapping("/dashboard")
    public String showDashboard() {
        // This renders src/main/resources/templates/dashboard.ftlh
        return "dashboard";
    }
}
