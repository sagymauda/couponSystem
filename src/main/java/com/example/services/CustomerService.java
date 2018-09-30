package com.example.services;

import com.example.database.Enums.CouponType;
import com.example.database.entity.Coupon;
import com.example.database.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    public void purchaseCoupon(Coupon coupon,Customer customer);

    public List<Coupon> getAllPurchasedCouponsByCutomer(Customer customer);

    public List<Coupon> getAllPurchasedCouponsType(CouponType type);

    public List<Coupon> getAllPurchasedCouponsByPriceUpTo(double price);





}
