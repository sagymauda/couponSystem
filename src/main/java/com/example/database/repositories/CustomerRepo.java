package com.example.database.repositories;

import com.example.database.entity.Company;
import com.example.database.entity.Coupon;
import com.example.database.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//inside the<> the first one(long)is the id, and what i expect to get id customer
public interface CustomerRepo extends JpaRepository<Customer,Long> {

    default List<Customer> findCustomersByCoupon(Coupon coupon) {

        return findCustomersByCouponsContains(coupon);
    }

    default List<Customer> findCustomersByCompany(Company company)
    {
        return findCustomersByCompanyId(company.getId());
    }


    public List<Customer> findCustomersByCouponsContains(Coupon coupon);

    @Query(value = "select customer.* from customer, coupon, company, coupon_customers " +
            "where customer.id = coupon_customers.customers_id " +
            "and coupon_customers.coupons_id = coupon.id " +
            "and coupon.company_id = company.id " +
            "and company.id = ?1", nativeQuery = true)
    public List<Customer> findCustomersByCompanyId(Long companyId);
}
