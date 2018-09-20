package com.example.services;

import com.example.database.Enums.CouponType;
import com.example.database.entity.Company;
import com.example.database.entity.Coupon;
import com.example.database.repositories.CompanyRepo;
import com.example.database.repositories.CouponRepo;
import com.example.database.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class companyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepo companyRepo;
    @Autowired
    private CouponRepo couponRepo;

    @Override
    public void createCoupon(Coupon coupon) {
        List<Coupon> coupons = new ArrayList<>();
        coupons = couponRepo.findAll();
        int counter = 0;
        for (Coupon coup : coupons) {
            if (coup.getTitle().equals(coupon.getTitle())) {
                System.out.println("could not create the coupon");
                counter++;
            }
            if (counter < 0) {
                couponRepo.save(coupon);
            }
        }

    }

    @Override
    public void removeCoupon(Coupon coupon) {

    }

    @Override
    public void updateCoupon(Coupon coupon) {
        Coupon coupon1 = new Coupon();
        coupon1.setEnd_Date(coupon.getEnd_Date());
        coupon1.setPrice(coupon.getPrice());
        couponRepo.save(coupon1);
    }

    @Override
    public Coupon getCouponById(long id) {
        Coupon coupon = new Coupon();
        coupon = couponRepo.getCouponById(id);

        return coupon;
    }

    @Override
    public List<Coupon> getAllCoupons() {
        List<Coupon> coupons = new ArrayList<>();
        coupons = couponRepo.findAll();

        return coupons;
    }

    @Override
    public List<Coupon> getAllByType(CouponType type) {
        List<Coupon> coupons = new ArrayList<>();
        coupons = couponRepo.getCouponsByType(type);
        //here  i stoped!!!!!
        return coupons;
    }
}
