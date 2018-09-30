package com.example.services;

import com.example.database.Enums.CouponType;
import com.example.database.entity.Coupon;
import com.example.database.entity.Customer;
import com.example.database.repositories.CouponRepo;
import com.example.database.repositories.CustomerRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class customerServiceImpl implements CustomerService {
    private static final Logger logger = LoggerFactory.getLogger(customerServiceImpl.class);
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private CouponRepo couponRepo;

    @Override
    public void purchaseCoupon(Coupon coupon,Customer customer) {
        Set<Customer> customers = new HashSet<>();
        int counter=0;
        customers.add(customer);
        for(Customer cust : customers){
            if(cust.getCoupons().contains(coupon)){
                counter++;
                logger.error("cannot dd coupon allready bought it ");
            }
            if(coupon.getAmount()==0){
                counter++;
                logger.error("cannot buy coupon  no amount");
            }
        }
        if(counter!=0) {
            coupon.setCustomers(customers);
            couponRepo.save(coupon);
        }

    }

    @Override
    public List<Coupon> getAllPurchasedCouponsByCutomer (Customer customer){
        List<Coupon>coupons= new ArrayList<>();
        coupons=couponRepo.findCouponsByCustomer(customer);

        return coupons;
    }

    @Override
    public List<Coupon> getAllPurchasedCouponsType(CouponType type) {
        List<Coupon>coupons= new ArrayList<>();
coupons=couponRepo.findAllByType(type);

        return coupons ;
    }

    @Override
    public List<Coupon> getAllPurchasedCouponsByPriceUpTo(double price) {
        List<Coupon>coupons = new ArrayList<>();
        coupons=couponRepo.findAllByPriceIsLessThanEqual(price);

        return coupons;
    }
}
