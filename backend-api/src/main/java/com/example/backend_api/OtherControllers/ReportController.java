package com.example.backend_api.OtherControllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReportController {

    @GetMapping("/Reports")
    public String showReports(Model model) {


        return "Reports";
    }
}
