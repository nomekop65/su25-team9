package com.example.backend_api.Customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Object getallCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerByUsername(String username) {
        return customerRepository.findByUsername(username);
    }

    public Customer getCustomerByUserId(Long userId) {
        return customerRepository.findByUserId(userId);
    }

    public Customer getCustomerByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Long userId, Customer customer) {
        return customerRepository.save(customer);
    }

    public void deleteCustomer(Long userId) {
        customerRepository.deleteById(userId);
    }

    public List<Customer> getCustomersByReview(String review) {
        return customerRepository.findAll().stream()
                .filter(customer -> customer.getReview().stream().anyMatch(r -> r.toString().equals(review)))
                .toList();
    }

    public List<Customer> getCustomersOrderlist(String userId) {
        Long orderId = Long.parseLong(userId);
        return customerRepository.findAll().stream()
                .filter(customer -> customer.getOrderId().stream().anyMatch(order -> order.getId().equals(orderId)))
                .toList();
    }

    public Customer addOrderIdToCustomer(Long userId, Long orderId) {
        Customer customer = customerRepository.findByUserId(userId);
        if (customer != null) {
            List<Order> orders = customer.getOrderId();
            orders.add(new Order(orderId,customer));
            return customerRepository.save(customer);
        }
        return null;

    }
    public Customer addReviewToCustomer(Long userId, String review) {
        Customer customer = customerRepository.findByUserId(userId);
        if (customer != null) {
            List<Review> reviews = customer.getReview();
            reviews.add(new Review(review)); // Assuming Review has a constructor that takes a String
            customer.setReview(reviews);
            return customerRepository.save(customer);
        }
        return null;
    }
}
