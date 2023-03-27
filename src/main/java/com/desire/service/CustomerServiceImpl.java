package com.desire.service;

import com.desire.dao.CustomerDao;
import com.desire.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.regex.Pattern;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerDao customerDao;

    @Autowired
    public CustomerServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public void addCustomer(String email, String firstName, String lastName, String zip, String country) {
        //TODO validate request fields
        Customer customer = new Customer();
        if (!isEmailValid(email)) {
            //TODO: implement a custom error message
            throw new RuntimeException();
        }
        customer.setEmail(email);

        if (firstName == null || firstName.trim().length() <1) {
            //TODO: implement a custom error message
            throw new RuntimeException();
        }
        customer.setFirstName(firstName);

        if (lastName == null || lastName.trim().length() <1) {
            //TODO: implement a custom error message
            throw new RuntimeException();
        }
        customer.setLastName(lastName);

        if (zip == null || zip.trim().length() <1) {
            //TODO: implement a custom error message
            throw new RuntimeException();
        }
        customer.setZipCode(zip);

        if (country == null || country.trim().length() <1) {
            //TODO: implement a custom error message
            throw new RuntimeException();
        }
        customer.setCountry(country);
        customerDao.save(customer);
    }

    @Override
    public Customer getCustomer(Long id) {
        Customer customer = customerDao.findById(id).get();
        if (customer == null) {
            //TODO: implement a custom error message
            throw new NullPointerException();
        }
        return customer;
    }

    @Override
    public Collection<Customer> getAllCustomers() {
        return customerDao.findAll();
    }

    @Override
    public Customer updateCustomer(Long id,Customer customerRecord) {

        Customer customer = getCustomer(id);
        customer.setZipCode(customerRecord.getZipCode());
        customer.setCountry(customerRecord.getCountry());
        customerDao.save(customer);
        return customer;
    }

    @Override
    public Customer removeCustomer(Long id) {
        Customer customer = getCustomer(id);
        customerDao.deleteById(id);
        return customer;
    }

    @Override
    public boolean isEmailValid(String email) {
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        return Pattern.compile(regexPattern)
                .matcher(email)
                .matches();
    }
}
