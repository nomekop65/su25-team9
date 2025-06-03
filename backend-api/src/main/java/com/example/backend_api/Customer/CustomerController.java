package com.example.backend_api.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController

public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public Object getAllCustomers() {
        return customerService.getallCustomers();
    }
    @GetMapping("/customers/{username}")
    public Customer getCustomerByUsername(@PathVariable String username) {
        return customerService.getCustomerByUsername(username);
    }
    @GetMapping("/customers/userId/{userId}")
    public Customer getCustomerByUserId(@PathVariable Long userId) {
        return customerService.getCustomerByUserId(userId);
    }

    @GetMapping("/customers/review")
    public List<Customer> getCustomersByReview(@RequestParam String review) {
        return customerService.getCustomersByReview(review).stream()
                .filter(customer -> customer.getReview().stream()
                        .anyMatch(r -> r.toString().contains(review)))
                .toList();
    }

    @GetMapping("/customers/orderId/{orderId}")
    public List<Customer> getCustomersByOrderId(@PathVariable String orderId) {
        Long orderIdLong;
        try {
            orderIdLong = Long.parseLong(orderId);
        } catch (NumberFormatException e) {
            return List.of(); // or handle error as appropriate
        }
        return customerService.getCustomersOrderlist(orderId).stream()
                .filter(customer -> customer.getOrderId().stream()
                        .anyMatch(order -> order.getId().equals(orderIdLong)))
                .toList();
    }


    @PostMapping("/customers")
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    @PostMapping("/customers/orderid/{userId}")
    public Customer addOrderIdToCustomer(@PathVariable Long userId, @RequestBody Long orderId) {
        return customerService.addOrderIdToCustomer(userId, orderId);
    }

    @PostMapping("/customers/review/{userId}")
    public Customer addReviewToCustomer(@PathVariable Long userId, @RequestBody String review) {
        return customerService.addReviewToCustomer(userId, review);
    }


    @PutMapping("/customers/{userId}")
    public Customer updateCustomer(@PathVariable Long userId, @RequestBody Customer customer) {
        return customerService.updateCustomer(userId, customer);
    }

    @DeleteMapping("/customers/{userId}")
    public void deleteCustomer(@PathVariable Long userId) {
        customerService.deleteCustomer(userId);
    }


    
}
