package com.example.database.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    private String CustName;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER,mappedBy = "customers")
    private List<Coupon> coupons= new ArrayList<>();

    public Customer() {
    }

    public Customer(String custName, String password) {
        CustName = custName;
        this.password = password;
    }

    public void addCoupon(Coupon coupon) {
        this.coupons.add(coupon);
    }

    public List<Coupon> getCoupons() {
        return coupons;
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


    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", CustName='" + CustName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}