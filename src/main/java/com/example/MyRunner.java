package com.example;

import com.example.database.entity.Customer;
import com.example.database.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    private CustomerRepo repo ;
    @Override
    public void run(String... args) throws Exception {
        System.out.println("hi nesamaaa!!!!!");
        Customer customer = new Customer();
        customer.setCustName("sagi");
        customer.setPassword("lsdisverygood");
        repo.save(customer);

        Customer c1 = repo.findByName("sagi");
        System.out.println(c1);
    }
}
