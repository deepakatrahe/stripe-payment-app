package com.example.stripepayment.service;

import com.example.stripepayment.dto.PaymentInfo;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

public interface CheckoutService {
    PaymentIntent createPaymentIntent(PaymentInfo paymentInfo) throws StripeException;
}
