package com.example.services;

import com.example.database.Enums.CouponType;
import com.example.database.entity.Coupon;
import com.example.database.repositories.CouponRepo;
import com.example.database.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class customerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private CouponRepo couponRepo;

    @Override
    public void purchaseCoupon(Coupon coupon) {

    }

    @Override
    public List<Coupon> getAllPurchasedCoupons() {
        return null;
    }

    @Override
    public List<Coupon> getAllPurchasedCouponsType(CouponType type) {
        return null;
    }

    @Override
    public List<Coupon> getAllPurchasedCouponsByPrice(double price) {
        return null;
    }
}
