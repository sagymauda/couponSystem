package com.example;

import com.example.database.Enums.CouponType;
import com.example.database.entity.Company;
import com.example.database.entity.Coupon;
import com.example.database.entity.Customer;
import com.example.database.repositories.CompanyRepo;
import com.example.database.repositories.CouponRepo;
import com.example.database.repositories.CustomerRepo;
import com.example.services.adminServiceImpl;
import com.example.utils.PopDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    private CustomerRepo custrepo;
    @Autowired
    private CouponRepo couponRepo;
    @Autowired
    private CompanyRepo companyRepo;
    @Autowired
    adminServiceImpl adminService;

    public void run(String... args) throws Exception {
        //creating 2 companies and 2 customers
        Company company1 = new Company("sagis", "1111", "S@M.com");
        companyRepo.save(company1);
 Company company2= new Company("maudas","2222","S@mm.com");
        companyRepo.save(company2);
Customer customer1 = new Customer("sagi","password");


//Customer customer2 = new Customer("mauda","pass");
//        custrepo.save(customer2);
////creating 6  coupons
        Coupon coupon1 = new Coupon();
        coupon1.setTitle("im coupon 1");
coupon1.setCompany(company1);
couponRepo.save(coupon1);
Coupon coupon2= new Coupon();
coupon2.setTitle("im coupon 2");
coupon2.setCompany(company1);
couponRepo.save(coupon2);
//coupon2.setType(CouponType.CAMPING);
Coupon coupon3= new Coupon();
coupon3.setTitle("im coupon 3");
coupon3.setCompany(company2);
couponRepo.save(coupon3);
Coupon coupon4= new Coupon();
coupon4.setTitle("im coupon 4");
coupon4.setCompany(company2);
couponRepo.save(coupon4);
Coupon coupon5= new Coupon();
coupon5.setTitle("im coupon 5");
coupon5.setCompany(company1);
couponRepo.save(coupon5);
        customer1.addCoupon(coupon5);

        custrepo.save(customer1);
//Coupon coupon6= new Coupon();
//coupon6.setTitle("im coupon 6");
////setting company to coupon
//coupon1.setCompany(company1);
//coupon2.setCompany(company1);
//coupon3.setCompany(company1);
//coupon4.setCompany(company2);
//coupon5.setCompany(company2);
//coupon6.setCompany(company2);
////setting customers to coupons
//coupon1.addCustomer(customer1);
//coupon2.addCustomer(customer1);
//coupon3.addCustomer(customer1);
//coupon4.addCustomer(customer2);
//coupon5.addCustomer(customer2);
//coupon6.addCustomer(customer2);
//
//couponRepo.save(coupon1);
//couponRepo.save(coupon2);
//couponRepo.save(coupon3);
//couponRepo.save(coupon4);
//couponRepo.save(coupon5);
//couponRepo.save(coupon6);
//
////there is a diffrent between objects of java and objects of data base , only when i get the data from the data base he is recognise the coupons.
//
//        //chcking all the methods in CompanyRepo
//        List<Company>companies = new ArrayList<>();
//        companies=companyRepo.findAll();
//        System.out.println("-------------AllCompanies-------------");
//        System.out.println(companies.toString());
//        Company company= companyRepo.getCompanyById(company1.getId());
//        System.out.println("-------------getCompanyById-------------");
//        System.out.println(company.toString());
//        List<Coupon>coupons=couponRepo.findCouponsByCompany(company1);
//        System.out.println("-------------getCouponsByCompany-------------");
//        System.out.println(coupons.toString());
//
//        System.out.println("----------CustomerRepo--------------------");
//        List<Customer>customers = new ArrayList<>();
//        customers=custrepo.findAll();
//        System.out.println("-------------Allcustomers-------------");
//        System.out.println(customers.toString());
//        Customer customer= custrepo.getCustomerById(customer1.getId());
//        System.out.println("-------------getCustomerById-------------");
//        System.out.println(company.toString());
//        List<Coupon>couponsForCustomers=couponRepo.findCouponsByCustomers(Collections.singletonList(customer1));
//        System.out.println("-------------getCouponsByCustomers-------------");
//        System.out.println(couponsForCustomers.toString());
//
//
//
//        System.out.println("----------CouponsRepo--------------------");
//        List<Coupon>couponsFromCpuonRepo = new ArrayList<>();
//        couponsFromCpuonRepo=couponRepo.findAll();
//        System.out.println("-------------AllCoupons-------------");
//        System.out.println(couponsFromCpuonRepo.toString());
//        Coupon couponById = couponRepo.getCouponById(coupon1.getId());
//        System.out.println("-------------getcCouponById-------------");
//        System.out.println(couponById.toString());
//        List<Coupon>coupons2 = new ArrayList<>();
//        coupons2 =couponRepo.getCouponsByType(CouponType.CAMPING);
//        System.out.println("-------------getCouponsByCustomers-------------");
//        System.out.println(coupons2.toString());
//        coupon1.setTitle("Gorge");
//        couponRepo.save(coupon1);
//        System.out.println(coupon1.getTitle());
//        Company companyForCheck= new Company("sagis","1234","S@M.com");
//
//         adminService.createCompany(companyForCheck);
//       List<Coupon>newList=new ArrayList<>();
//
//
//        System.out.println(newList);
//     //   couponRepo.removeCouponsByCompanyId(company1.getId());
//       newList= couponRepo.findCouponsByCustomers(Collections.singletonList(customer1));
//        System.out.println("=====================this is whay important it needs to be empty=====================");
//        System.out.println(newList);
//    }
      //  coupon1.setCompany(company1);
    //    company1.addCoupon(coupon1);
    //    companyRepo.save(company1);

//companyRepo.delete(company1.getId());
    }
}
