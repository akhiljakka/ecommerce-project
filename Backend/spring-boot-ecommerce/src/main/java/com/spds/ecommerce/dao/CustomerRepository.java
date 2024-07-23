package com.spds.ecommerce.dao;

import com.spds.ecommerce.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

//import org.springframework.stereotype.Repository;


public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Customer findByEmail(
            String theEmail);

}
