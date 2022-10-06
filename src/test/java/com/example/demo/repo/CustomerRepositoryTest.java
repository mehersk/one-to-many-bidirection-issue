package com.example.demo.repo;

import com.example.demo.domain.Address;
import com.example.demo.domain.AddressType;
import com.example.demo.domain.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerRepositoryTest {
    @Autowired
    CustomerRepository customerRepository;
    @Test
    void saveCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("3firstname");
        Address address1 = new Address();
        address1.setAddressLine1("1line1");
        address1.setAddressLine2("1line2");
        address1.setAddressType(AddressType.HOME);
        address1.setCity("1City");

        Address address2 = new Address();
        address2.setAddressLine1("2line1");
        address2.setAddressLine2("2line2");
        address2.setState("2state");
        customer.getAddressBook().add(address1);
        customer.getAddressBook().add(address2);
        Customer newCustomer = customerRepository.save(customer);
        System.out.println(newCustomer.toString());
        System.out.println(customerRepository.findAll());
    }

    @Test
    void getCustomers () {
        List<Customer> customers = customerRepository.findAll();
        System.out.println(customers.toString());
    }

}