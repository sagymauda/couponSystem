package com.example.database.entity;

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
    private String eMail;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id")
    private List<Coupon> coupons = new ArrayList<>();

    public Company() {}

    public Company(String companyName, String password, String eMail) {
        this.companyName = companyName;
        this.password = password;
        this.eMail = eMail;
    }
   public void addCoupon(Coupon coupon){
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

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", password='" + password + '\'' +
                ", eMail='" + eMail + '\'' +
                '}';
    }
}
