package com.example.backend_api.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ReviewRepository reviewRepository;

    // Handle Add Comment Submission
    @PostMapping("/add")
    public String addComment(@RequestParam Long customerId,
                             @RequestParam Long providerId,
                             @ModelAttribute Review review) {
        User customer = userRepository.findById(customerId).orElseThrow();
        User provider = userRepository.findById(providerId).orElseThrow();
        review.setCustomer(customer);
        review.setProvider(provider);
        reviewRepository.save(review);
        return "redirect:/customers";
    }

    // View Comments for a Customer
    @GetMapping("/view/{customerId}")
    public String viewComments(@PathVariable Long customerId, Model model) {
        User customer = userRepository.findById(customerId).orElseThrow();
        List<Review> reviews = reviewRepository.findByCustomer(customer);
        model.addAttribute("customer", customer);
        model.addAttribute("reviews", reviews);
        return "view_comments";
    }

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

    // Show Add Comment Form (Customer Only)
    @GetMapping("/add/{customerId}")
    public String showAddCommentForm(@PathVariable Long customerId, Model model) {
        model.addAttribute("customerId", customerId);
        // If you have a logged-in provider, add their ID as well
        // model.addAttribute("providerId", providerId);
        model.addAttribute("review", new Review());
        return "add_comment";
    }
}
