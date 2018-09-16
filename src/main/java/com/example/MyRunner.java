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
import java.util.ArrayList;
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
Coupon coupon1= new Coupon();
coupon1.setTitle("second title company");
Coupon coupon2= new Coupon();
coupon2.setTitle("thired title coulo[b");
couponRepo.save(coupon1);
couponRepo.save(coupon2);
  couponRepo.save(coupon);
company.addCoupon(coupon);
company.addCoupon(coupon1);
company.addCoupon(coupon2);
companyRepo.save(company);
Company company1= companyRepo.getCompanyById(company.getId());
        System.out.println(company1);

List<Coupon>coupons= new ArrayList<>();
   //   System.out.println(coupons=company1.getCoupons());


        System.out.println("gfttttggggggggggggg");
        System.out.println();
    }
    }

