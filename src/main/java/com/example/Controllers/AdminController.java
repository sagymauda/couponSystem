package com.example.Controllers;

import com.example.database.entity.Company;
import com.example.database.entity.Customer;
import com.example.services.adminServiceImpl;
import com.example.services.companyServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
    @Autowired
    adminServiceImpl adminService;
    @Autowired
    companyServiceImpl companyService;

    @PostMapping("/createcompany")
    public void createCompany(Company company){
        adminService.createCompany(company);
    }
    @PostMapping("/removecompany")
    public void removeCompany(Company company){
        adminService.removeCompany(company);
    }
    @PostMapping("/updatecompany")
    public void updateCompany(Company company){
        adminService.updateCompany(company);
    }
    @GetMapping("/getcompany")
    public Company getCompany(long id){
        Company company = new Company();
        company=adminService.getCompany(id);
        return  company;
    }
    @GetMapping("/getallcompanies")
    public List<Company> getAllCompanies(){
        List<Company>companies= new ArrayList<>();
       companies= adminService.getAllCompanies();
       return  companies;
    }
    @PostMapping("/createcustomer")
    public void createCustomer(Customer customer){
        adminService.createCustomer(customer);
    }
    @PostMapping("/removecustomer")
    public void removeCustomer(Customer customer){
        adminService.removeCustomer(customer);
    }
    @PostMapping("/updatecustomer")
    public void updateCustomer(Customer customer){
        adminService.updateCustomer(customer);
    }
@GetMapping("/getcustomer")
    public Customer getCustomer(long id){
        Customer customer = new Customer();
        customer= adminService.getCustomer(id);
        return  customer;

    }
    @GetMapping("/getallcustomers")
    public List<Customer>getAllCustomers(){
        List<Customer>customers= new ArrayList<>();
        customers=  adminService.getAllCustomers();
        return  customers;
    }
}
