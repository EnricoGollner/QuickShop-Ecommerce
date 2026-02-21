package dev.enricogollner.basketservice.controller;

import dev.enricogollner.basketservice.controller.request.BasketRequest;
import dev.enricogollner.basketservice.controller.request.PaymentRequest;
import dev.enricogollner.basketservice.entity.Basket;
import dev.enricogollner.basketservice.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/basket")
@RequiredArgsConstructor
public class BasketController {
    private final BasketService service;

    @GetMapping("/{id}")
    public ResponseEntity<Basket> getById(@PathVariable String id) {
        return ResponseEntity.ok(service.getBasketById(id));
    }

    @PostMapping
    public ResponseEntity<Basket> create(@RequestBody BasketRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createBasket(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Basket> update(@PathVariable String id, @RequestBody BasketRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(service.updateBasket(id, request));
    }

    @PutMapping("/{id}/payment")
    public ResponseEntity<Basket> payBasket(@PathVariable String id, @RequestBody PaymentRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(service.payBasket(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Basket> delete(@PathVariable String id) {
        service.deleteBasket(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
