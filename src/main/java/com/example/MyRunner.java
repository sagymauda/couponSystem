package com.example;

import com.example.database.Enums.CouponType;
import com.example.database.entity.Company;
import com.example.database.entity.Coupon;
import com.example.database.entity.Customer;
import com.example.database.repositories.CompanyRepo;
import com.example.database.repositories.CouponRepo;
import com.example.database.repositories.CustomerRepo;
import com.example.services.AdminService;
import com.example.utils.PopDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class MyRunner implements CommandLineRunner {


    @Autowired
    private CustomerRepo custrepo;
    @Autowired
    private CouponRepo couponRepo;
    @Autowired
    private CompanyRepo companyRepo;
    @Autowired
    private AdminService adminService;

    public void run(String... args) throws Exception {
        Company company2 = new Company("benis", "2222", "S@mM.com");
        Company company3 = new Company("gorgies", "2222", "S@mM.com");
        companyRepo.save(company2);
        companyRepo.save(company3);
        Company company = new Company("sagis", "2222", "S@mM.com");
        Coupon coupon = new Coupon();
        coupon.setTitle("title nesamam sagiii");
        company.addCoupon(coupon);
        Coupon c1 = new Coupon();
        c1.setTitle("hhhh");
        c1.setType(CouponType.CAMPING);
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
        coupon = couponRepo.findOne(coupon.getId());
        //  customer.addCoupon(coupon);
        coupon.setCustomers(Arrays.asList(customer));
        custrepo.save(customer);
        couponRepo.save(coupon);
        //     System.out.println(custrepo.findCustomersByCoupons(Collections.singletonList(coupon)));
        System.out.println(custrepo.findCustomersByCouponsContains(coupon));
        Customer customer1 = custrepo.findOne(1L);
        System.out.println(customer1);
        System.out.println("--------------------");
        System.out.println(couponRepo.findCouponsByCustomersContains(customer1));
        System.out.println(couponRepo.findCouponsBySingleCustomer(customer1));
        //companyRepo.delete(c);
        List<Coupon> another = couponRepo.findAllByType(CouponType.CAMPING);
        System.out.println(another.toString());
        Customer customer2 = new Customer();
        customer2 = custrepo.getCustomerById(customer1.getId());
        Company company1 = new Company("sagis", "2222", "S@mM.com");
        adminService.createCompany(company1);
        adminService.removeCompany(company);
        company1.setPassword("new password throw update");
        adminService.updateCompany(company1);
        Company company4 = new Company();
        company4 = adminService.getCompany(company1.getId());
        System.out.println(";;;;;;;;;;;;;;;;;;;;;;;;;;;;;;---------------;;;;;;;;;;;;;;;;;;;;;;;;;;;;;");
        System.out.println(company4.toString());
        List<Company>companies = new ArrayList<>();
        companies=companyRepo.findAll();
        System.out.println(companies.toString());
        Customer customer3= new Customer();
        customer3.setCustName("shahaf");
        adminService.createCustomer(customer3);
        adminService.removeCustomer(customer);
    }

}

