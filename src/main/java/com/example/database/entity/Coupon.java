package com.example.database.entity;

import com.example.database.Enums.CouponType;

import javax.persistence.*;
import java.util.*;

@Entity
public class Coupon {
    @Id
    @GeneratedValue
    private long id;
    private String title;
    private Date start_Date;
    private Date end_Date;
    private int amount;
    private CouponType type;
    private String message;
    private double price;
    private String image;

    @ManyToOne
    private Company company;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Customer> customers = new HashSet<>();

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    public void removeCustomer(Customer customer) {
        this.customers.remove(customer);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStart_Date() {
        return start_Date;
    }

    public void setStart_Date(Date start_Date) {
        this.start_Date = start_Date;
    }

    public Date getEnd_Date() {
        return end_Date;
    }

    public void setEnd_Date(Date end_Date) {
        this.end_Date = end_Date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Enum getType() {
        return type;
    }

    public void setType(CouponType type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", start_Date=" + start_Date +
                ", end_Date=" + end_Date +
                ", amount=" + amount +
                ", type=" + type +
                ", message='" + message + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coupon coupon = (Coupon) o;

        return title.equals(coupon.title);
    }

    @Override
    public int hashCode() {
        return title.hashCode();
    }
}
