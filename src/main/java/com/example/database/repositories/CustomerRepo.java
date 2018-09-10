package com.example.database.repositories;

import com.example.database.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
//inside the<> the first one(long)is the id, and what i expect to get id customer
public interface CustomerRepo extends JpaRepository<Customer, Long> {

    public Customer findByName(String name);





}
