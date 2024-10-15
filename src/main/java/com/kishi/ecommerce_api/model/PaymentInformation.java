package com.kishi.ecommerce_api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.time.LocalDateTime;




public class PaymentInformation {
    @Column(name="cardholder_name")
    private String cardHolderName;
    @Column(name = "card_number")
    private String cardNumber;

    @Column(name="expiration_date")
    private LocalDateTime expirationDate;

    @Column(name = "cvv")
    private String cvv;



}
