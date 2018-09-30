package com.example.services;

import com.example.database.entity.Company;
import com.example.database.entity.Coupon;
import com.example.database.entity.Customer;
import com.example.database.repositories.CompanyRepo;
import com.example.database.repositories.CouponRepo;
import com.example.database.repositories.CustomerRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class adminServiceImpl implements AdminService {
    private static final Logger logger = LoggerFactory.getLogger(adminServiceImpl.class);


    @Autowired
    private CompanyRepo companyRepo;
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private CouponRepo couponRepo;

    @Override
    public void createCompany(Company company) {
        List<Company> companies = new ArrayList<>();
        companies = companyRepo.findAll();
        int counter = 0;
        for (Company com : companies) {
            if (com.getCompanyName().equals(company.getCompanyName())) {
                logger.error("could not create the company");
                counter++;
            }
            if (counter < 0) {
                companyRepo.save(company);
            }
        }
    }


    @Override
    public void removeCompany(Company company) {
        // delete company (first delete it's coupons)
        List<Coupon> coupons = couponRepo.findCouponsByCompany(company);
        for (Coupon c : coupons) {
            couponRepo.delete(c);
        }
        companyRepo.delete(company);

    }

    @Override
    public void updateCompany(Company company) {
        Company company1 = new Company();
        company1.setPassword(company.getPassword());
        company1.setEmail(company.getEmail());
        companyRepo.save(company1);

    }

    @Override
    public Company getCompany(long id) {
        Company company = new Company();
        company=companyRepo.getCompanyById(id);
        return null;
    }

    @Override
    public List<Company> getAllCompanies() {
        List<Company> companies = new ArrayList<>();
        companies=companyRepo.findAll();
        return companies;
    }

    @Override
    public void createCustomer(Customer customer) {
        List<Customer> customers = new ArrayList<>();
        customers = customerRepo.findAll();
        int counter = 0;
        for (Customer cust : customers) {
            if (cust.getCustName().equals(customer.getCustName())) {
                logger.error("could not create the customer");
                counter++;
            }
            if (counter < 0) {
                customerRepo.save(customer);
            }
        }
    }

    @Override
    public void removeCustomer(Customer customer) {
        // delete customer (first remove it from all coupons)
        List<Coupon> customerCoupons1 = couponRepo.findCouponsByCustomer(customer);
        for (Coupon c : customerCoupons1) {
            c.removeCustomer(customer);
            couponRepo.save(c);
        }
        customerRepo.delete(customer);

    }

    @Override
    public void updateCustomer(Customer customer) {
    Customer customer1= new Customer();
    customer1.setPassword(customer.getPassword());
    customerRepo.save(customer1);
    }

    @Override
    public Customer getCustomer(long id) {
        Customer customer =new Customer();
        customer=customerRepo.getOne(id);
        return customer;
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer>customers=new ArrayList<>();
        customers=customerRepo.findAll();
        return customers;
    }
}
