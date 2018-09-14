package com.example.database.repositories;

import com.example.database.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

//inside the<> the first one(long)is the id, and what i expect to get id customer
@Repository
public interface CustomerRepo extends JpaRepository<Customer,Long> {
    public void createCustomer(Customer customer);

}
