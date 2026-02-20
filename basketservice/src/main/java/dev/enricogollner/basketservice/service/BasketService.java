package dev.enricogollner.basketservice.service;

import dev.enricogollner.basketservice.client.response.PlatziProductResponse;
import dev.enricogollner.basketservice.controller.request.BasketRequest;
import dev.enricogollner.basketservice.entity.Basket;
import dev.enricogollner.basketservice.entity.Product;
import dev.enricogollner.basketservice.entity.Status;
import dev.enricogollner.basketservice.repository.BasketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BasketService {
    private final BasketRepository repository;
    private final ProductService productService;

    public Basket getBasketById(String id) {
        return  repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Basket with id " + id + " not found"));
    }

    public Basket createBasket(BasketRequest request) {
        repository.findByClientAndStatus(request.clientId(), Status.OPEN)
                .ifPresent(basket -> {
                    throw new IllegalArgumentException("There is already an open basket for this client");
                });

        List<Product> products = new ArrayList<>();
        request.products().forEach(productRequest -> {
            PlatziProductResponse response = productService.getById(productRequest.id());
            products.add(
                    Product.builder()
                        .id(response.id())
                        .title(response.title())
                        .price(response.price())
                        .quantity(productRequest.quantity())
                        .build()
            );

        });


        Basket basket = Basket.builder()
                .client(request.clientId())
                .status(Status.OPEN)
                .products(products)
                .build();

        basket.calculateTotalPrice();
        return repository.save(basket);
    }

}
