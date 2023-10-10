package com.example.stripepayment.serviceImpl;

import com.example.stripepayment.dto.PaymentInfo;
import com.example.stripepayment.entities.CustomerRepository;
import com.example.stripepayment.service.CheckoutService;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckoutServiceImpl implements CheckoutService {
    private final CustomerRepository customerRepository;
    public CheckoutServiceImpl(CustomerRepository customerRepository, @Value("${stripe.keys.public}") String secretKey) {
        this.customerRepository = customerRepository;
        Stripe.apiKey = secretKey;
    }

}

    @Override
    public PaymentIntent createPaymentIntent(PaymentInfo paymentInfo) throws StripeException {
        List<String> paymentMethodTypes=new ArrayList<>();
        paymentMethodTypes.add("card");

        Map<String,Object> params=new HashMap<>();
        params.put("amount",paymentInfo.getAmount());
        params.put("currency",paymentInfo.getCurrency());
        params.put("payment_method_types",paymentMethodTypes);
        return PaymentIntent.create(params);
    }
}
