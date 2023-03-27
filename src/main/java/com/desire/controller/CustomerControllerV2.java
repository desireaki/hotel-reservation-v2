package com.desire.controller;

import com.desire.model.Customer;
import com.desire.service.CustomerServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
@RequestMapping("api/v2/customers")
public class CustomerControllerV2 {
    private final CustomerServiceImpl customerService;

    @Autowired
    public CustomerControllerV2(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @GetMapping(("{customerId}"))
    Customer getCustomerById(
            @PathVariable("customerId") Long id){
        Customer customer = customerService.getCustomerByKey(id);
        return customer;
    }

    @GetMapping(("email/{email}"))
    Customer getCustomerByEmail(
            @PathVariable("email") String email){
        Customer customer = customerService.getCustomerByEmail(email);
        return customer;
    }

    @GetMapping
    Collection<Customer> getAllCustomer(){
        return customerService.getAllCustomers();
    }

    @PostMapping("/add")
    void addCustomer(
            @Valid
            @RequestBody NewCustomerRequest request){
        Customer customer = new Customer();
        customer.setEmail(request.email());
        customer.setFirstName(request.firstName());
        customer.setLastName(request.lastName());
        customer.setZipCode(request.zipCode());
        customer.setCountry(request.country());
        customerService.addCustomer(customer);
    }

    @DeleteMapping("{customerId}")
    Customer removeCustomer(
            @PathVariable("customerId") Long customerId){
        return customerService.removeCustomer(customerId);
    }

    @PutMapping("{customerId}")
    Customer updateCustomer(
            @PathVariable("customerId") Long customerId,
            @RequestBody NewCustomerRequest request){
        Customer customer = new Customer();
        customer.setEmail(request.email());
        customer.setFirstName(request.firstName());
        customer.setLastName(request.lastName());
        customer.setZipCode(request.zipCode());
        customer.setCountry(request.country());
        return customerService.updateCustomer(customerId, customer);
    }

    record NewCustomerRequest (@NotBlank(message = "email must be not empty")
                               String email,
                               String zipCode,
                               String country,
                               @NotBlank(message = "first name must be not empty")
                               String firstName,
                               @NotBlank(message = "last name must be not empty")
                               String lastName) {

    }
}
