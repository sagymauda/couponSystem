package com.example.CouponSystemSagi.com.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Set;

@Entity
public class Customer {
    @Id
    long id;
    String CustName;
    String password;
    private Set<Coupon> couponSet;


    public Set<Coupon> getCouponSet() {
        return couponSet;
    }

    public void setCouponSet(Set<Coupon> couponSet) {
        this.couponSet = couponSet;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getCustName() {
        return CustName;
    }

    public void setCustName(String custName) {
        CustName = custName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}