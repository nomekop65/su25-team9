package com.example.backend_api.User;

import jakarta.persistence.*;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;

    @ManyToOne
    @JoinColumn(name = "provider_id")
    private User provider;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private User customer;

    public Review() {}

    public Review(String comment) {
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getProvider() {
        return provider;
    }

    public User getCustomer() {
        return customer;
    }

    public void setProvider(User provider) {
        this.provider = provider;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }
    
    public void setCustomerandProvider(User customer, User provider) {
        this.provider = provider;
        this.customer = customer;
    }
}
