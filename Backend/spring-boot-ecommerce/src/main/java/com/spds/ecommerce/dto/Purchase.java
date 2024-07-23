package com.spds.ecommerce.dto;

import com.spds.ecommerce.entity.Address;
import com.spds.ecommerce.entity.Customer;
import com.spds.ecommerce.entity.Order;
import com.spds.ecommerce.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;

}
