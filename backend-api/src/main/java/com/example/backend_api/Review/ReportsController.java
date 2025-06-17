package com.example.backend_api.Review;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.backend_api.User.User;
import com.example.backend_api.User.UserService;

@Controller
@RequestMapping("/reports")
public class ReportsController {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private UserService userService;

    @GetMapping
public String showReports(Model model) {
    model.addAttribute("reviews", Optional.ofNullable(reviewService.getAllReviews()).orElse(List.of()));
    return "Reports";
}


    

    @GetMapping("/reply/{reviewId}")
    public String showReplyForm(@PathVariable Long reviewId, Model model) {
        Review review = reviewService.getReviewById(reviewId);
        model.addAttribute("review", review);
        return "reply_form";  // create this Freemarker template
    }

    @PostMapping("/reply")
    public String submitReply(@RequestParam Long reviewId,
                              @RequestParam String reply) {
        Review review = reviewService.getReviewById(reviewId);
        review.setReply(reply);
        reviewService.saveReview(review);
        return "redirect:/reports";
    }
}
