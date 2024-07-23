package com.spds.ecommerce.service;

import com.spds.ecommerce.dto.Purchase;
import com.spds.ecommerce.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}
