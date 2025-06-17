package com.example.backend_api.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.backend_api.User.User;
import com.example.backend_api.User.UserService;

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
                                @RequestParam String username,
                                @RequestParam String password) {

        // Create new User with email and password (you can add username later)
        User user = new User();
        user.setEmail(email);
        user.setUsername(username); // simple default username
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
    @GetMapping("/modify_profile")
public String showModifyProfileForm() {
    return "modify_profile";
}

@PostMapping("/modify_profile")
public String processModifyProfile(@RequestParam String email,
                                   @RequestParam String currentPassword,
                                   @RequestParam String newPassword) {

    User user = userService.findByEmail(email);
    if (user == null || !user.getPassword().equals(currentPassword)) {
        // optional: redirect with error param
        return "redirect:/modify_profile?error=true";
    }

    user.setPassword(newPassword);
    userService.createUser(user); // reuse createUser to save update

    return "redirect:/dashboard";
}

}
