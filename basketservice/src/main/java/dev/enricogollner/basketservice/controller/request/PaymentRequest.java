package dev.enricogollner.basketservice.controller.request;

import dev.enricogollner.basketservice.entity.PaymentMethod;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentRequest {
    private PaymentMethod paymentMethod;
}
