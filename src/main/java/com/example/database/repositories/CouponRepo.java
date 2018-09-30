package com.example.database.repositories;

import com.example.database.Enums.CouponType;
import com.example.database.entity.Company;
import com.example.database.entity.Coupon;
import com.example.database.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CouponRepo extends JpaRepository<Coupon, Long> {

    @Query(value = "SELECT * FROM coupon c WHERE c.company_id = ?1", nativeQuery = true)
    public List<Coupon> findCouponsByCompanyId(Long companyId);

    public List<Coupon> findCouponsByCustomersContains(Customer customer);

    public List<Coupon> findCouponsByCompany(Company company);

    default List<Coupon> findCouponsByCustomer(Customer customer){
        return findCouponsByCustomersContains(customer);
    }

}
