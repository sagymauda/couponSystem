package com.example.services;

import com.example.database.Enums.CouponType;
import com.example.database.entity.Coupon;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    public void purchaseCoupon(Coupon coupon);

    public List<Coupon> getAllPurchasedCoupons();

    public List<Coupon> getAllPurchasedCouponsType(CouponType type);

    public List<Coupon> getAllPurchasedCouponsByPrice(double price);





}
