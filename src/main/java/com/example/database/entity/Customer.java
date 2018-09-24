package com.example.database.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Customer implements Serializable {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private String CustName;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "customers")
    private Set<Coupon> coupons = new HashSet<>();

    public Customer() {
    }

    public Customer(String custName, String password) {
        CustName = custName;
        this.password = password;
    }

    public void addCoupon(Coupon coupon) {
        this.coupons.add(coupon);
    }

    public Set<Coupon> getCoupons() {
        return coupons;
    }

    public void setCoupons(Set<Coupon> coupons) {
        this.coupons = coupons;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        return CustName.equals(customer.CustName);
    }

    @Override
    public int hashCode() {
        return CustName.hashCode();
    }
}