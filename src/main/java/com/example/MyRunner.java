package com.example;

import com.example.database.entity.Company;
import com.example.database.entity.Coupon;
import com.example.database.entity.Customer;
import com.example.database.repositories.CompanyRepo;
import com.example.database.repositories.CouponRepo;
import com.example.database.repositories.CustomerRepo;
import com.example.services.customerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private CouponRepo couponRepo;
    @Autowired
    private CompanyRepo companyRepo;
    @Autowired
    private customerServiceImpl customerService;

    public void run(String... args) throws Exception {
        // create new company
        Company company = new Company("sagis", "1111", "S@mM.com");
        companyRepo.save(company);

        // create new coupon and associate it to a company
        Coupon coupon1 = new Coupon();
        coupon1.setTitle("coupon1");
        coupon1.setPrice(3.0);
        coupon1.setCompany(company);
        couponRepo.save(coupon1);

        Coupon coupon2 = new Coupon();
        coupon1.setTitle("coupon2");
        coupon1.setPrice(5.0);
        coupon1.setCompany(company);
        coupon1.setAmount(0);
        couponRepo.save(coupon2);

        // create new customer
        Customer customer = new Customer();
        customer.setCustName("me");
        customerRepo.save(customer);

        // create new customer
        Customer customer1 = new Customer();
        customer1.setCustName("me2");
        customerRepo.save(customer1);

        // customer buy a coupon
        Set<Customer> customers = new HashSet<>();
        customers.add(customer);
        customers.add(customer1);
        coupon1.setCustomers(customers);
        couponRepo.save(coupon1);

        // find all company's coupons
//        List<Coupon> companyCoupons = couponRepo.findCouponsByCompany(company);
//        System.out.println(companyCoupons);
//
//        // find all customers who bought a coupon
//        List<Customer> couponCustomers = customerRepo.findCustomersByCoupon(coupon1);
//        System.out.println(couponCustomers);
//
//        // find all coupons bought by a customer
//        List<Coupon> customerCoupons = couponRepo.findCouponsByCustomer(customer);
//        System.out.println(customerCoupons);
//
//        List<Coupon> coponsPrice = couponRepo.findAllByPrice(3.0);
//        System.out.println("sdgaaaaaaaaaaaaaaaaaaaaaaaaaaallllllkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
//        System.out.println(coponsPrice);
//
//
//
//        // find all company's customers
//        List<Customer> customers1 = customerRepo.findCustomersByCompany(company);
//        System.out.println(customers1);
//
//        // delete coupon
//    //   couponRepo.delete(coupon1);
//
//      // delete customer (first remove it from all coupons)
//       List<Coupon> customerCoupons1 = couponRepo.findCouponsByCustomer(customer);
///      for (Coupon c : customerCoupons1) {
//            c.removeCustomer(customer);
//           couponRepo.save(coupon1);
//        }
//        customerRepo.delete(customer);
//
//
//        // delete company (first delete it's coupons)
//       List<Coupon> coupons = couponRepo.findCouponsByCompany(company);
//        for (Coupon c : coupons) {
//           couponRepo.delete(c);
//        }
//        companyRepo.delete(company);
       // customerService.purchaseCoupon(coupon2,customer);
        List<Coupon>coupons= new ArrayList<>();

        coupons=  customerService.getAllPurchasedCouponsByPriceUpTo(4.0);
        System.out.println(coupons.toString()+"fhrghgfgrthrthrthrth");
        System.out.println("making a change");
    }

}

