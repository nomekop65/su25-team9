package com.example.backend_api.Provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProviderService {

    @Autowired
    private ProviderRepository repo;

    public Provider createProvider(Provider p) {
        return repo.save(p);
    }

    public Provider updateProvider(Long id, Provider updated) {
        Provider existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Provider not found"));

        existing.setEmail(updated.getEmail());
        existing.setUsername(updated.getUsername());
        existing.setReviews(updated.getReviews());
        existing.setOrderIds(updated.getOrderIds());

        return repo.save(existing);
    }

    public void deleteProvider(Long id) {
        repo.deleteById(id);
    }

    public List<Provider> getAllProviders() {
        return repo.findAll();
    }
}
