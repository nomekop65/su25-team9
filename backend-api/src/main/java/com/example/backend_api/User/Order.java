package com.example.backend_api.User;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String item_type_id;

    private Long Quantity;

    private float price;

    private boolean buyer;

    private boolean isAvailable;

    public Order() {}

    public Order(User user, String item_type_id, Long Quantity, float price, boolean buyer, boolean isAvailable) {
        this.user = user;
        this.item_type_id = item_type_id;
        this.Quantity = Quantity;
        this.price = price;
        this.buyer = buyer;
        this.isAvailable = isAvailable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getitem_type_id() {
        return item_type_id;
    }

    public void setitem_type_id(String item_type_id) {
        this.item_type_id = item_type_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getQuantity() {
        return Quantity;
    }

    public void setQuantity(Long quantity) {
        Quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;

    }

    public boolean isBuyer() {
        return buyer;
    }

    public void setBuyer(boolean buyer) {
        this.buyer = buyer;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

}
