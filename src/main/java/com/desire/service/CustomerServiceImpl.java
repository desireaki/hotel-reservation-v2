package com.desire.service;

import com.desire.dao.CustomerDao;
import com.desire.exception.ApiRequestException;
import com.desire.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerDao customerDao;

    @Autowired
    public CustomerServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public void addCustomer(String email, String firstName, String lastName, String zip, String country) {
        Customer customer = new Customer();
        customer.setEmail(email);
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setZipCode(zip);
        customer.setCountry(country);
        customerDao.save(customer);
    }

    @Override
    public void addCustomer(Customer customer) {
        customerDao.save(customer);
    }

    @Override
    public Customer getCustomerByKey(Long id) {
        Optional<Customer> customer = customerDao.findById(id);
        if (customer.isEmpty()) {
            //TODO: implement a custom error message
            throw new ApiRequestException(
                    "customer with id " + id + " not found");
        }
        return customer.get();
    }

    @Override
    public Customer getCustomerByEmail(String email) {
        return customerDao.findByEmail(email);
    }

    @Override
    public Collection<Customer> getAllCustomers() {
        return customerDao.findAll();
    }

    @Override
    public Customer updateCustomer(Long id, Customer customerRecord) {

        Customer customer = getCustomerByKey(id);
        customer.setZipCode(customerRecord.getZipCode());
        customer.setCountry(customerRecord.getCountry());
        customerDao.save(customer);
        return customer;
    }

    @Override
    public Customer removeCustomer(Long id) {
        Customer customer = getCustomerByKey(id);
        customerDao.deleteById(id);
        return customer;
    }

}
