package com.example.database.repositories;

import com.example.database.Enums.CouponType;
import com.example.database.entity.Coupon;
import com.example.database.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepo extends JpaRepository<Coupon,Long> {
    public void createCoupon(Coupon coupon);
}
