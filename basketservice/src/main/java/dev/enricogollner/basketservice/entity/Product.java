package dev.enricogollner.basketservice.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Product {
    private Long id;
    private String title;
    private BigDecimal totalPrice;
    private Integer quantity;
}
