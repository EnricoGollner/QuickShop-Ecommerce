package dev.enricogollner.basketservice.repository;

import dev.enricogollner.basketservice.entity.Basket;
import dev.enricogollner.basketservice.entity.Status;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BasketRepository extends MongoRepository<Basket, String> {
    Optional<Basket> findByClientAndStatus(Long client, Status status);
}
