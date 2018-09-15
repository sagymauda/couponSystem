package com.example.database.repositories;

import com.example.database.entity.Company;
import com.example.database.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CompanyRepo extends JpaRepository<Company, Long> {
    public Company getCompanyById(long id);

    public List<Company> findAll();

// @Query("SELECT " +
//         "    new com.example.database.entity.Coupon(v.answer, COUNT(v)) " +
//         "FROM " +
//         "    Survey v " +
//         "GROUP BY " +
//         "    v.answer")
//public List<Coupon> getCoupons();


}
