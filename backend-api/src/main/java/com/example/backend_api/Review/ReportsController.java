package com.example.backend_api.Review;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/reports")
public class ReportsController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public String showReports(Model model) {
        List<Review> reviews = Optional.ofNullable(reviewService.getAllReviews()).orElse(List.of());

        System.out.println("Fetched reviews: " + reviews.size());
for (Review r : reviews) {
    System.out.println("Comment: " + r.getComment() + " | Reply: " + r.getReply());
}

        
        model.addAttribute("reviews", reviews);
        return "Reports";
    }

    @GetMapping("/reply/{reviewId}")
    public String showReplyForm(@PathVariable Long reviewId, Model model) {
        Review review = reviewService.getReviewById(reviewId);
        if (review == null) {
            return "redirect:/reports"; // or some error page
        }
        model.addAttribute("review", review);
        return "reply_form";
    }

    @PostMapping("/reply")
    public String submitReply(@RequestParam Long reviewId,
                              @RequestParam String reply) {
        Review review = reviewService.getReviewById(reviewId);
        if (review == null) {
            return "redirect:/reports";
        }
        review.setReply(reply);
        reviewService.saveReview(review);
        return "redirect:/reports";
    }
}
