package com.example.database.repositories;

import com.example.database.entity.Company;
import com.example.database.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
@Repository
public interface CompanyRepo extends JpaRepository<Company,Long> {
    public void createCompany(Company company);


}
