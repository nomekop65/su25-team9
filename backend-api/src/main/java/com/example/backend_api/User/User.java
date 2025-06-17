package com.example.backend_api.User;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

import com.example.backend_api.Order.Order;
import com.example.backend_api.Review.Review;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String username;

    private String password;

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

    public User(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
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


    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }    

    public List<Review> getProviderReviews() {
        return providerReviews;
    }

    public List<Review> getCustomerReviews() {
        return customerReviews;
    }

    public void setReviews(List<Review> reviews) {
        this.providerReviews = reviews;
        for (Review r : reviews) {
            r.setProvider(this);
        }
    }

    public void setCustomerReviews(List<Review> reviews) {
        this.providerReviews = reviews;
        for (Review r : reviews) {
            r.setCustomer(this);
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
