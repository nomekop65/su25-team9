package com.example.backend_api.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User createUser(User p) {
        return repo.save(p);
    }

    public User updateUser(Long id, User updated) {
        User existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        existing.setEmail(updated.getEmail());
        existing.setUsername(updated.getUsername());
        existing.setReviews(updated.getReviews());
        existing.setOrderIds(updated.getOrderIds());

        return repo.save(existing);
    }
    public User getUserById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public List<String>getreviewByusername(String username) {
        return repo.findByUsername(username).getReviews().stream()
                .map(review -> review.getComment())
                .toList();
    }
    

    public void deleteUser(Long id) {
        repo.deleteById(id);
    }

    public List<User> getAllUsers() {
        return repo.findAll();
    }
}
