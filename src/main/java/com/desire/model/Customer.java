package com.desire.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Setter;

@Setter
@Entity
public class Customer {

    @Id
    @SequenceGenerator(
            name = "customer_id_sequence",
            sequenceName = "customer_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_id_sequence"
    )
    private Long id;
    private String firstName;
    private String lastName;
    private String zipCode;
    private String country;
    @Email(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")
    private String email;



    /**
     * This is the main constructor for the customer class
     * @param firstName Customer's first name
     * @param lastName Customer's second nme
     * @param email Customer's last name
     */
    public Customer(Long id, String firstName, String lastName, String email, String zipCode, String country) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.zipCode = zipCode;
        this.country = country;

    }

    public Customer() {

    }

    @JsonIgnore
    public Long getId() {
        return id;
    }

    @JsonProperty("firstname")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("lastname")
    public String getLastName() {
        return lastName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCountry() {
        return country;
    }

    public String getEmail() {
        return email;
    }

}
