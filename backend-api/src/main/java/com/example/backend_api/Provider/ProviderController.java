package com.example.backend_api.Provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/providers")
public class ProviderController {

    @Autowired
    private ProviderService service;

    @PostMapping
    public Provider createProvider(@RequestBody Provider provider) {

        if (provider.getReviews() != null) {
            for (Review r : provider.getReviews()) {
                r.setProvider(provider);
            }
        }

        if (provider.getOrderIds() != null) {
            for (Order o : provider.getOrderIds()) {
                o.setProvider(provider);
            }
        }

        return service.createProvider(provider);
    }

    @GetMapping
    public List<Provider> getAllProviders() {
        return service.getAllProviders();
    }

    @PutMapping("/{id}")
    public Provider updateProvider(@PathVariable Long id, @RequestBody Provider provider) {
        return service.updateProvider(id, provider);
    }

    @DeleteMapping("/{id}")
    public void deleteProvider(@PathVariable Long id) {
        service.deleteProvider(id);
    }
}
