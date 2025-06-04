package com.example.backend_api.User;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String username;

    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Review> providerReviews = new ArrayList<>();

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Review> customerReviews = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Order> orderIds = new ArrayList<>();

    public User() {}

    public User(String email, String username) {
        this.email = email;
        this.username = username;
    }

    public void addReview(Review review) {
        providerReviews.add(review);
        review.setProvider(this);
    }

    public void removeReview(Review review) {
        providerReviews.remove(review);
        review.setProvider(null);
    }

    public void addOrder(Order order) {
        orderIds.add(order);
        order.setUser(this);
    }

    public void removeOrder(Order order) {
        orderIds.remove(order);
        order.setUser(null);
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
        return providerReviews;
    }

    public void setReviews(List<Review> reviews) {
        this.providerReviews = reviews;
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
            o.setUser(this);
        }
    }
}
