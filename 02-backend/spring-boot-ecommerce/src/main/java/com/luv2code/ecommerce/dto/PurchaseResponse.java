package com.luv2code.ecommerce.dto;

import lombok.Data;

@Data
public class PurchaseResponse {

    private final String orderTrackingNumber; // final turi būti, nes arba anotacija @NotNull, nes kitaip neveiks
                                              // CheckoutServiceImpl placeOrder(Purchase purchase)
}
