package com.spds.ecommerce.service;

import com.spds.ecommerce.dao.CustomerRepository;
import com.spds.ecommerce.dto.Purchase;
import com.spds.ecommerce.dto.PurchaseResponse;
import com.spds.ecommerce.entity.Customer;
import com.spds.ecommerce.entity.Order;
import com.spds.ecommerce.entity.OrderItem;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

   private CustomerRepository customerRepository;
   public CheckoutServiceImpl(CustomerRepository customerRepository){
       this.customerRepository = customerRepository;
   }


    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase){
       //retirve the order info from dto
        Order order = purchase.getOrder();


        // generate tracking number
        String oredrTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(oredrTrackingNumber);
        //populate order with orderItems
        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(item -> order.add(item));

        //populate order with biling address
        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());

        Customer customer = purchase.getCustomer();

        String theEmail = customer.getEmail();
        Customer customerFromDb = customerRepository.findByEmail(theEmail);
        if (customerFromDb != null){
            customer = customerFromDb;
        }


        customer.add(order);


        customerRepository.save(customer);

        return new PurchaseResponse(oredrTrackingNumber);

    }

    private String generateOrderTrackingNumber(){
       //generate a random UUID number
        // For details see: ________________
        return UUID.randomUUID().toString();
    }
}
