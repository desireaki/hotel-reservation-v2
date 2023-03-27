package com.desire.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
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

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", country='" + country + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
