package com.example.backend_api.Review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend_api.User.User;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> getReviewsByCustomer(User customer) {
        return reviewRepository.findByCustomer(customer);
    }

    public Review getReviewById(Long id) {
        return reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found"));
    }

    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }
    public List<Review> getAllReviews() {
    return reviewRepository.findAll();
}

}
