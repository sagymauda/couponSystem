package com.example.database.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Company {

    @Id
    @GeneratedValue
    private long id;
    private String companyName;
    private String password;
    private String email;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "company")
    private List<Coupon> coupons = new ArrayList<>();

    public Company() {
    }

    public Company(String companyName, String password, String email) {
        this.companyName = companyName;
        this.password = password;
        this.email = email;
    }

    public void addCoupon(Coupon coupon) {
        this.coupons.add(coupon);
    }

    public List<Coupon> getCoupons() {
        return coupons;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
