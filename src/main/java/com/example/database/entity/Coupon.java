package com.example.database.entity;

import com.example.database.Enums.CouponType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @ManyToMany
    private List<Customer> customers= new ArrayList<>();

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }


    ;
//     public  Coupon(){}
//    public Coupon(String title, Date start_Date, Date end_Date, int amount, CouponType type, String message, double price, String image) {
//        this.title = title;
//        this.start_Date = start_Date;
//        this.end_Date = end_Date;
//        this.amount = amount;
//        this.type = type;
//        this.message = message;
//        this.price = price;
//        this.image = image;
//    }

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

}
