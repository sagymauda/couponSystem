package com.example.services;

import com.example.database.Enums.CouponType;
import com.example.database.entity.Coupon;

import java.util.List;

public interface CompanyService {
    public void createCoupon(Coupon coupon);

    public void removeCoupon(Coupon coupon);

    public void updateCoupon(Coupon coupon);

    public Coupon getCouponById(long id);

    public List<Coupon> getAllCoupons();

    public List<Coupon> getAllByType(CouponType type);

    public List<Coupon> getAllByPrice(double price);
}
