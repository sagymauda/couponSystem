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
import java.util.*;

@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    private CustomerRepo custrepo ;
    @Autowired
    private CouponRepo couponRepo ;
    @Autowired
    private CompanyRepo companyRepo;

    public void run(String... args) throws Exception {
        Company company = new Company("sagis", "2222", "S@mM.com");
        Coupon coupon = new Coupon();
        coupon.setTitle("title nesamam sagiii");

        company.addCoupon(coupon);

        Coupon c1 = new Coupon();
        c1.setTitle("hhhh");
        company.addCoupon(c1);

        companyRepo.save(company);
        Company c = companyRepo.getCompanyById(company.getId());
        System.out.println(c.getCoupons());
        System.out.println("-------------------");
        System.out.println(couponRepo.findCouponsByCompanyId(c.getId()));
        System.out.println(couponRepo.findCouponsByCompany(c));
        System.out.println("-------------------");
        Customer customer = new Customer();
        customer.setCustName("shahaf");
        customer.addCoupon(coupon);
        coupon.setCustomers(Collections.singletonList(customer));

//        custrepo.save(customer);
        couponRepo.save(coupon);
        System.out.println(custrepo.findCustomersByCoupons(Collections.singletonList(coupon)));
        System.out.println(custrepo.findCustomersByCouponsContains(coupon));
        Customer customer1 = custrepo.findOne(1L);
        System.out.println(customer1);
        System.out.println("--------------------");
        System.out.println(couponRepo.findCouponsByCustomersContains(customer1));
        System.out.println(couponRepo.findCouponsBySingleCustomer(customer1));
        companyRepo.delete(c);

//        final String[] lesquestions = {"random1", "random2", "random3"};
        List<String> lesquestions = Arrays.asList("random1", "random2", "random3");
        lesquestions.remove()
    }

}

