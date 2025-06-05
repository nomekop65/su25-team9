package com.example.backend_api.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping
    public User createUser(@RequestBody User user) {

        if (user.getProviderReviews() != null) {
            for (Review r : user.getProviderReviews()) {
                r.setProvider(user);
            }
        }

        if (user.getOrderIds() != null) {
            for (Order o : user.getOrderIds()) {
                o.setUser(user);
            }
        }

        return service.createUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/id/{id}")
    public User getUserById(@PathVariable Long id) {
        return service.getUserById(id);
    }

    @GetMapping("/username/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return service.getAllUsers().stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @GetMapping("/reviews/{username}")
    public List<String> getReviewsByUsername(@PathVariable String username) {
        return service.getreviewByusername(username);
    }
    @GetMapping("/orders/{username}")
    public List<Order> getOrdersByUsername(@PathVariable String username) {
        return service.getAllUsers().stream()
                .filter(user -> user.getUsername().equals(username))
                .flatMap(user -> user.getOrderIds().stream())
                .toList();
    }

    @PostMapping("/orders/{id}")
    public Order addOrderToUser(@PathVariable Long id, @RequestBody Order order) {
        User user = service.getUserById(id);
        order.setUser(user);
        return orderRepository.save(order);
    }
    @PostMapping("/reviews/{customerId}/{providerId}")
    public Review addReviewToUser(@PathVariable Long customerId, @PathVariable Long providerId, @RequestBody Review review) {
        User customer = service.getUserById(customerId);
        User provider = service.getUserById(providerId);
        review.setCustomerandProvider(customer, provider);
        provider.getProviderReviews().add(review);
        return reviewRepository.save(review);
    }


    @PostMapping("/login")
    public User login(@RequestBody User user) {
        return service.getAllUsers().stream()
                .filter(u -> u.getEmail().equals(user.getEmail()) && u.getPassword().equals(user.getPassword()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User provider) {
        return service.updateUser(id, provider);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
    }
}
