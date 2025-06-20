package com.example.backend_api.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;


import java.util.List;
import java.util.Map;
import java.util.HashMap;
import com.example.backend_api.User.User; // Add this import, adjust the package if needed
import com.example.backend_api.User.UserRepository; // Add this import, adjust the package if needed
import com.example.backend_api.Products.ProductRepository; // Add this import, adjust the package if needed
import com.example.backend_api.Products.Product; // Add this import, adjust the package if needed

@Controller
public class OrderController {
    @Autowired
    private OrderService service;

    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private UserRepository UserRepository;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return service.createOrder(order);
    }

    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable Long id, @RequestBody Order updated) {
        return service.updateOrder(id, updated);
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return service.getOrderById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        service.deleteOrder(id);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return service.getAllOrders();
    }

    @PutMapping("/availability/{id}")
    public void isAvailable(@PathVariable Long id, @RequestParam boolean isAvailable) {
        service.isAvailable(id, isAvailable);
    }
    @GetMapping("/orders")
    public String showOrders(Model model) {
        List<Order> orders = orderRepository.findAll();

        // Build a map of item_type_id (as String) to typename
        Map<String, String> typeNames = new HashMap<>();
        for (Product product : productRepository.findAll()) {
            typeNames.put(String.valueOf(product.getId()), product.getName()); // or getTypename()
        }

        model.addAttribute("orders", orders);
        model.addAttribute("typeNames", typeNames);
        return "Orders"; // or "orders" if your template is lowercase
    }

    @PostMapping("/create")
    public String createOrder(@RequestParam Integer productId,
                              @RequestParam String username,
                              @RequestParam String role,
                              @RequestParam Long quantity,
                              @RequestParam float price) {
        Order order = new Order();
        order.setitem_type_id(productId);
        User user = UserRepository.findByUsername(username);
        order.setUser(user);
        System.out.println(role);
        if ("buyer".equals(role)) {
            order.setBuyer(true);
        } else if ("seller".equals(role)) {
            order.setBuyer(false);
        }
        order.setQuantity(quantity);
        order.setPrice(price);
        order.setAvailable(true); // Assuming new orders are available by default
        orderRepository.save(order);
        return "redirect:/orders";
    }

    @PostMapping("/orders/accept")
    public String acceptOrder(@RequestParam Long orderId) {
        orderRepository.deleteById(orderId);
        return "redirect:/orders";
    }
}