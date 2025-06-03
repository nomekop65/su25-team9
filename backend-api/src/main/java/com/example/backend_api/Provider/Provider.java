package com.example.backend_api.Provider;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String username;

    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orderIds = new ArrayList<>();

    public Provider() {}

    public Provider(String email, String username) {
        this.email = email;
        this.username = username;
    }

    public void addReview(Review review) {
        reviews.add(review);
        review.setProvider(this);
    }

    public void removeReview(Review review) {
        reviews.remove(review);
        review.setProvider(null);
    }

    public void addOrder(Order order) {
        orderIds.add(order);
        order.setProvider(this);
    }

    public void removeOrder(Order order) {
        orderIds.remove(order);
        order.setProvider(null);
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
        for (Review r : reviews) {
            r.setProvider(this);
        }
    }

    public List<Order> getOrderIds() {
        return orderIds;
    }

    public void setOrderIds(List<Order> orderIds) {
        this.orderIds = orderIds;
        for (Order o : orderIds) {
            o.setProvider(this);
        }
    }
}
