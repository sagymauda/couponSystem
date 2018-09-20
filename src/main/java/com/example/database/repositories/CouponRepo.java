package com.example.database.repositories;

import com.example.database.Enums.CouponType;
import com.example.database.entity.Company;
import com.example.database.entity.Coupon;
import com.example.database.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CouponRepo extends JpaRepository<Coupon,Long> {
public Coupon getCouponById(long id);
public List<Coupon> getCouponsByType(CouponType type);

  public  List<Coupon> findAll();
  public  List<Coupon> findCouponsByCompany(Company company);
  public  List<Coupon> findCouponsByCustomers(List<Customer> customers);
  //  public  void removeCouponsByCompanyId(long id);

}
