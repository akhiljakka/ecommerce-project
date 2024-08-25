package com.spds.ecommerce.service;

import com.spds.ecommerce.dto.PaymentInfo;
import com.spds.ecommerce.dto.Purchase;
import com.spds.ecommerce.dto.PurchaseResponse;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);

    PaymentIntent createPaymentIntent(PaymentInfo paymentInfo) throws StripeException;
}
