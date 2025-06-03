package com.example.backend_api.Customer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> getCustomerByUsername(String username);
    @Query("SELECT p FROM Customer p WHERE p.username = ?1")
    Customer findByUsername(String username);
    @Query("SELECT p FROM Customer p WHERE p.userId = ?1")
    Customer findByUserId(Long userId);
    @Query("SELECT p FROM Customer p WHERE p.email = ?1")
    Customer findByEmail(String email);

}
