package dev.enricogollner.basketservice.service;

import dev.enricogollner.basketservice.client.PlatziStoreClient;
import dev.enricogollner.basketservice.client.response.PlatziProductResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {
    private final PlatziStoreClient platziStoreClient;

    @Cacheable(value = "products")
    public List<PlatziProductResponse> getAll() {
        log.info("Getting all products");
        return platziStoreClient.getAllProducts();
    }

    @Cacheable(value = "product", key = "#productId")
    public PlatziProductResponse getById(Long productId) {
        log.info("Getting product with Id: {}", productId);
        return platziStoreClient.getProductById(productId);
    }
}
