package com.example.backend_api.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.backend_api.User.User;
import com.example.backend_api.User.UserService;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String processLogin(@RequestParam String email,
                                @RequestParam String password) {
        User user = userService.getAllUsers().stream()
                .filter(u -> u.getEmail().equals(email) && u.getPassword().equals(password))
                .findFirst()
                .orElse(null);

        if (user != null) {
            // Valid login, redirect to dashboard
            return "redirect:/dashboard";
        } else {
            // Invalid login, maybe redirect back with error
            return "redirect:/index";
        }
    }
}
