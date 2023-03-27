package com.desire.service;

import com.desire.model.Customer;
import java.util.Collection;

public interface CustomerService {
    /**
     * This method takes the customer info and create a new customer's account.
     * @param email Customer's email
     * @param firstName Customer's first name
     * @param lastName Customer's last name
     */
    void addCustomer(String email, String firstName, String lastName, String zip, String country);

    /**
     * This method takes the customer info and create a new customer's account.
     * @param customer New customer
     */
    void addCustomer(Customer customer);

    /**
     * This method returns the Customer profile information using provided customer id
     * @param id Customer's id
     * @return Customer profile info
     */
    Customer getCustomerByKey(Long id);

    /**
     * This method returns the Customer profile information using provided customer email
     * @param email Customer's email
     * @return Customer profile info
     */
    Customer getCustomerByEmail(String email);

    /**
     *This method returns the list of all customers
     * @return list of all the customer
     */
    Collection<Customer> getAllCustomers();

    /**
     * This method updates a customer's profile
     * @param updatedCustomer New customer information
     * @return Customer profile info
     */
    Customer updateCustomer(Long id, Customer updatedCustomer);

    /**
     * This method removes a customer with provided customer email
     * @param id Customer's email
     * @return Customer profile info
     */
    Customer removeCustomer(Long id);

}
