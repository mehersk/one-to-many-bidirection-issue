package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated(EnumType.STRING)
    private CustomerType customerType;
    private String firstName;
    private String lastName;
    private String billingName;
    private String gstin;
    private String email;
    private String workPhone;
    private String mobilePhone;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(pattern = "yyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime modifiedDate;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(pattern = "yyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime createdDate;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "customer")
    private List<Address> addressBook = new ArrayList<>();

    public Customer() {
    }

    public Customer(long id, CustomerType customerType, String firstName, String lastName, String billingName, String gstin, String email, String workPhone, String mobilePhone, LocalDateTime modifiedDate, LocalDateTime createdDate, List<Address> addressBook) {
        this.id = id;
        this.customerType = customerType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.billingName = billingName;
        this.gstin = gstin;
        this.email = email;
        this.workPhone = workPhone;
        this.mobilePhone = mobilePhone;
        this.modifiedDate = modifiedDate;
        this.createdDate = createdDate;
        this.addressBook = addressBook;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBillingName() {
        return billingName;
    }

    public void setBillingName(String billingName) {
        this.billingName = billingName;
    }

    public String getGstin() {
        return gstin;
    }

    public void setGstin(String gstin) {
        this.gstin = gstin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public List<Address> getAddressBook() {
        return addressBook;
    }

    public void setAddressBook(List<Address> addressBook) {
        this.addressBook = addressBook;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", customerType=" + customerType +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", billingName='" + billingName + '\'' +
                ", gstin='" + gstin + '\'' +
                ", email='" + email + '\'' +
                ", workPhone='" + workPhone + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", modifiedDate=" + modifiedDate +
                ", createdDate=" + createdDate +
                ", addressBook=" + addressBook +
                '}';
    }
}
