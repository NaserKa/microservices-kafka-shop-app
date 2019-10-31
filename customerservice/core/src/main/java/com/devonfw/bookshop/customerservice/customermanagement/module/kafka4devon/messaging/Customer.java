package com.devonfw.bookshop.customerservice.customermanagement.module.kafka4devon.messaging;

import java.time.Instant;

public class Customer {
    private String name;

    private String lastname;

    private String adress;

    private String city;

    private Instant lastChange;

    private Integer customerNumber;

    public Customer() {
    }

    public Customer(String name, String lastname, String adress, String city, Instant lastChange, Integer customerNumber) {
        this.name = name;
        this.lastname = lastname;
        this.adress = adress;
        this.city = city;
        this.lastChange = lastChange;
        this.customerNumber = customerNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Instant getLastChange() {
        return lastChange;
    }

    public void setLastChange(Instant lastChange) {
        this.lastChange = lastChange;
    }

    public Integer getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Integer customerNumber) {
        this.customerNumber = customerNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", adress='" + adress + '\'' +
                ", city='" + city + '\'' +
                ", lastChange=" + lastChange +
                ", customerNumber=" + customerNumber +
                '}';
    }
}
