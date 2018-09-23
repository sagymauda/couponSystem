package com.example.database.repositories;

import com.example.database.entity.Coupon;
import com.example.database.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

//inside the<> the first one(long)is the id, and what i expect to get id customer
public interface CustomerRepo extends JpaRepository<Customer,Long> {
//the list of customer will return only customers that have excacly all thecoupons in that list??no goooood!!!!!!!!!!!!!!
 //   public List<Customer> findCustomersByCoupons(List<Coupon> coupons);
     public Customer getCustomerById(long id);
    public List<Customer> findCustomersByCouponsContains(Coupon coupon);

}
