package com.lambdaschool.javaorders.models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private long ordnum;

    private double ordamount;
    private double advancementamount;
    private String orderdescription;

    @ManyToOne
    @JoinColumn(name = "custcode", nullable = false)
    private Customers customer;

    @ManyToMany()
    @JoinTable(name = "orderspayments", joinColumns = @JoinColumn(name = "ordnum"), inverseJoinColumns = @JoinColumn(name = "paymentid"))
    List<Payments> payments = new ArrayList<>();

    public Orders() {

    }

    public Orders(double ordamount, double advancementamount, String orderdescription, Customers customer) {
        this.ordamount = ordamount;
        this.advancementamount = advancementamount;
        this.orderdescription = orderdescription;
        this.customer = customer;
    }

    public long getOrdnum() {
        return ordnum;
    }

    public void setOrdnum(long ordnum) {
        this.ordnum = ordnum;
    }

    public double getOrdamount() {
        return ordamount;
    }

    public void setOrdamount(double ordamount) {
        this.ordamount = ordamount;
    }

    public double getAdvancementamount() {
        return advancementamount;
    }

    public void setAdvancementamount(double advancementamount) {
        this.advancementamount = advancementamount;
    }

    public String getOrderdescription() {
        return orderdescription;
    }

    public void setOrderdescription(String orderdescription) {
        this.orderdescription = orderdescription;
    }

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    public List<Payments> getPayments() {
        return payments;
    }

    public void setPayments(List<Payments> payments) {
        this.payments = payments;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "ordnum=" + ordnum +
                ", ordamount=" + ordamount +
                ", advancementamount=" + advancementamount +
                ", orderdescription='" + orderdescription + '\'' +
                ", customer=" + customer +
                ", payments=" + payments +
                '}';
    }
}
