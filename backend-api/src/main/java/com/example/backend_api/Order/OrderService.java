package com.example.backend_api.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repo;

    public Order createOrder(Order order) {
        return repo.save(order);
    }

    public Order updateOrder(Long id, @RequestBody Order updated) {
        Order existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        existing.setUser(updated.getUser());

        return repo.save(existing);
    }

    public Order getOrderById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public void deleteOrder(Long id) {
        repo.deleteById(id);
    }

    public List<Order> getAllOrders() {
        return repo.findAll();
    }

    public void isAvailable(Long id, boolean isAvailable) {
        Order existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        existing.setAvailable(isAvailable);
        repo.save(existing);
    }



}