package com.example.services;

import com.example.database.entity.Company;
import com.example.database.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AdminService {
     public void createCompany(Company company);

     public void removeCompany(Company company);

     public void updateCompany(Company company);

     public Company getCompany(long id);

     public List<Company> getAllCompanies();

     public void createCustomer(Customer customer);

     public void removeCustomer(Customer customer);

     public void updateCustomer(Customer customer);

     public Customer getCustomer(long id);

     public List<Customer>getAllCustomers();


}
