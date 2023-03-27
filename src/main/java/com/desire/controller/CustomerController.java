package com.desire.controller;

import com.desire.model.Customer;
import com.desire.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("api/v1/customers")
@Deprecated
public class CustomerController {
    private final CustomerServiceImpl customerService;

    @Autowired
    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @GetMapping(("{customerId}"))
    Customer getCustomerById(@PathVariable("customerId") Long id){
        Customer customer = customerService.getCustomerByKey(id);
        return customer;
    }

    @GetMapping
    Collection<Customer> getAllCustomer(){
        return customerService.getAllCustomers();
    }

    @PostMapping("/add")
    void addCustomer(@RequestBody NewCustomerRequest request){
        customerService.addCustomer(
                request.email(),
                request.firstName(),
                request.lastName(),
                request.zipCode(),
                request.country()
        );
    }

    @DeleteMapping("{customerId}")
    Customer removeCustomer(@PathVariable("customerId") Long customerId){
        return customerService.removeCustomer(customerId);
    }

    @PutMapping("{customerId}")
    Customer updateCustomer(@PathVariable("customerId") Long customerId,
                            @RequestBody NewCustomerRequest request){
        Customer customer = new Customer();
        customer.setEmail(request.email());
        customer.setFirstName(request.firstName());
        customer.setLastName(request.lastName());
        customer.setZipCode(request.zipCode());
        customer.setCountry(request.country());
        return customerService.updateCustomer(customerId, customer);
    }

    record NewCustomerRequest (String email,
                              String zipCode,
                              String country,
                              String firstName,
                              String lastName) {

    }
}
