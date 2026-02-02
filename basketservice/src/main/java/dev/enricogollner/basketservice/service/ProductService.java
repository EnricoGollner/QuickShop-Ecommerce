package dev.enricogollner.basketservice.service;

import dev.enricogollner.basketservice.client.PlatziStoreClient;
import dev.enricogollner.basketservice.client.response.PlatziProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final PlatziStoreClient platziStoreClient;

    public List<PlatziProductResponse> getAll() {
        return platziStoreClient.getAllProducts();
    }

    public PlatziProductResponse getById(Long id) {
        return platziStoreClient.getProductById(id);
    }
}
