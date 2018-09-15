package com.example;

import com.example.database.Enums.CouponType;
import com.example.database.entity.Company;
import com.example.database.entity.Coupon;
import com.example.database.entity.Customer;
import com.example.database.repositories.CompanyRepo;
import com.example.database.repositories.CouponRepo;
import com.example.database.repositories.CustomerRepo;
import com.example.utils.PopDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    private CustomerRepo custrepo ;
    @Autowired
    private CouponRepo couponRepo ;
    @Autowired
    private CompanyRepo companyRepo;

    public void run(String... args) throws Exception {
  Company company= new Company("sagis","1111","S@M.com");
  companyRepo.save(company);

  Coupon coupon= new Coupon();
  coupon.setTitle("title nesamam sagiii");
  couponRepo.save(coupon);
company.addCoupon(coupon);
companyRepo.save(company);
List<Coupon>coupons=couponRepo.findByCompany(company);

        System.out.println("gfttttggggggggggggg");
        System.out.println(coupons);
    }
    }

