package com.example.services;

import com.example.database.entity.Company;
import com.example.database.entity.Customer;
import com.example.database.repositories.CompanyRepo;
import com.example.database.repositories.CouponRepo;
import com.example.database.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class adminServiceImpl implements AdminService {

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
                System.out.println("could not create the company");
                counter++;
            }
            if (counter < 0) {
                companyRepo.save(company);
            }
        }
    }


    @Override
    public void removeCompany(Company company) {
    companyRepo.delete(company);

    }

    @Override
    public void updateCompany(Company company) {
        Company company1 = new Company();
        company1.setPassword(company.getPassword());
        company1.seteMail(company.geteMail());
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
                System.out.println("could not create the customer");
                counter++;
            }
            if (counter < 0) {
                customerRepo.save(customer);
            }
        }
    }

    @Override
    public void removeCustomer(Customer customer) {

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
        customer=customerRepo.getCustomerById(id);
        return customer;
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer>customers=new ArrayList<>();
        customers=customerRepo.findAll();
        return customers;
    }
}
