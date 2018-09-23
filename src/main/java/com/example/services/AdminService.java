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

import java.util.ArrayList;
import java.util.List;


@Component
public class AdminService {
    @Autowired
    private CompanyRepo companyRepo;
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private CouponRepo couponRepo;

    private static final Logger logger = LoggerFactory.getLogger(AdminService.class);

    public void createCompany(Company company) {
        List<Company> compaines = new ArrayList<>();
        int counter = 0;
        compaines = companyRepo.findAll();
        for (Company comp : compaines) {
            if (company.getCompanyName().equals(comp.getCompanyName())) {
                logger.error("cannot add company with the same name");
                counter++;
            }
        }
        if (counter == 0) {
            companyRepo.save(company);
        }


    }

    public void removeCompany(Company company){
        companyRepo.delete(company);

    }
    public void updateCompany(Company company){
        company.seteMail(company.geteMail());
        company.setPassword(company.getPassword());
        companyRepo.save(company);
    }
    public Company getCompany(long id){
        Company company = new Company();
        company=companyRepo.getCompanyById(id);
        return company;
    }
    public List<Company>getAllCompanies(){
        List<Company>companies= new ArrayList<>();
        companies=companyRepo.findAll();
        return companies;
    }
    public void createCustomer(Customer customer){
        List<Customer>customers= new ArrayList<>();
        int counter=0;
        customers=customerRepo.findAll();
        for(Customer cust :customers){
            if(cust.getCustName().equals(customer.getCustName())){
                logger.error("cannot save customer with the same name");
                counter++;
            }
        }
        if(counter>0){
            customerRepo.save(customer);
        }
    }
    public void removeCustomer(Customer customer){
        customerRepo.delete(customer);
    }
}



