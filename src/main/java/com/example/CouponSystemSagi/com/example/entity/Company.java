package com.example.CouponSystemSagi.com.example.entity;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import java.util.List;
import java.util.Set;

@Entity
public class Company {
    @Id
    long  id ;
    String companyName;
    String password;
    String eMail;
    private Set<Coupon> couponList;

    public Set<Coupon> getCouponList() {
        return couponList;
    }

    public void setCouponList(Set<Coupon> couponList) {
        this.couponList = couponList;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
